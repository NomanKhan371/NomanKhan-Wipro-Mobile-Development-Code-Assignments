package com.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private Connection connection;

    public Warehouse() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nomandb", "root", "K@pathan321");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addItem(Item item, int quantity) {
        String sql = "INSERT INTO Items (itemId, price, description, title, quantity) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, item.getItemId());
            pstmt.setDouble(2, item.getPrice());
            pstmt.setString(3, item.getDescription());
            pstmt.setString(4, item.getTitle());
            pstmt.setInt(5, quantity);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateItem(String itemId, double price, String description, String title, int quantity) {
        String sql = "UPDATE Items SET price = ?, description = ?, title = ?, quantity = ? WHERE itemId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, price);
            pstmt.setString(2, description);
            pstmt.setString(3, title);
            pstmt.setInt(4, quantity);
            pstmt.setString(5, itemId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteItem(String itemId) {
        String sql = "DELETE FROM Items WHERE itemId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, itemId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Item getItemById(String itemId) {
        String sql = "SELECT * FROM Items WHERE itemId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, itemId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Item(rs.getString("itemId"), rs.getDouble("price"), rs.getString("description"), rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getItemQuantity(String itemId) {
        String sql = "SELECT quantity FROM Items WHERE itemId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, itemId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM Items";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                items.add(new Item(rs.getString("itemId"), rs.getDouble("price"), rs.getString("description"), rs.getString("title")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public List<Integer> getQuantities() {
        List<Integer> quantities = new ArrayList<>();
        String sql = "SELECT quantity FROM Items";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                quantities.add(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantities;
    }
}
