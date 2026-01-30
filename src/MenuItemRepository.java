package repository;

import model.*;
import repository.interfaces.CrudRepository;
import exception.DatabaseOperationException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepository implements CrudRepository<MenuItem> {
    private final Connection connection;

    public MenuItemRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(MenuItem item) {
        String sql = "INSERT INTO menu_items (id, name, price, item_type) VALUES (?, ?, ?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, item.getId());
            st.setString(2, item.getName());
            st.setDouble(3, item.getBasePrice());
            st.setString(4, item instanceof Dish ? "DISH" : "DRINK");
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException("Postgres Insert Error: " + e.getMessage());
        }
    }

    @Override
    public List<MenuItem> findAll() {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String type = rs.getString("item_type");

                if ("DISH".equals(type)) {
                    items.add(new Dish(id, name, price, false));
                } else {
                    items.add(new Drink(id, name, price, 0.5));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException("Postgres Fetch Error: " + e.getMessage());
        }
        return items;
    }

    @Override
    public void update(MenuItem item) {
        String sql = "UPDATE menu_items SET name = ?, price = ? WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, item.getName());
            st.setDouble(2, item.getBasePrice());
            st.setInt(3, item.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException("Update failed");
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM menu_items WHERE id = ?";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException("Delete failed (FK check)"); [cite: 118]
        }
    }

    @Override
    public MenuItem findById(int id) {
        return null; // Implementation similar to findAll with WHERE id = ?
    }
}