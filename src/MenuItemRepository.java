import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepository implements CrudRepository<MenuItem> {
    private final Connection connection;

    public MenuItemRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(MenuItem item) {
        String sql = "INSERT INTO menu_items (id, name, price) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, item.getId());
            pstmt.setString(2, item.getName());
            pstmt.setDouble(3, item.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MenuItem> findAll() {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                items.add(new Dish(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), false));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    @Override public MenuItem findById(int id) { return null; }
    @Override public void update(MenuItem entity) {}
    @Override public void delete(int id) {}
}