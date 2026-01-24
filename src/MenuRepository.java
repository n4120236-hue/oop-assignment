package repository;
import model.*;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuRepository {

    public void save(MenuItem item) throws SQLException {
        String sql = "INSERT INTO menu_items (name, price, type, extra_info) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, item.getName());
            st.setDouble(2, item.getPrice());
            st.setString(3, item.getCategory());
            st.setString(4, item.getDetails());
            st.executeUpdate();
        }
    }

    public List<MenuItem> findAll() throws SQLException {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String type = rs.getString("type");
                if ("FOOD".equals(type)) {
                    items.add(new FoodItem(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getString("extra_info")
                    ));
                }
            }
        }
        return items;
    }
}