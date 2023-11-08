package com.york.EcommerceSystems.CatalogServices;
import com.york.EcommerceSystems.Database.catalog.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogServices {
    public List<Item> getItems() {
        String sql = "SELECT itemId, itemName,auctionType,description,startPrice,shippingTime,endDate FROM catalog";
        List<Item> items = new ArrayList<>();

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Item item = new Item();
                item.setItemId(rs.getLong("itemId"));
                item.setItemName(rs.getString("itemName"));
                item.setAuctionType(rs.getString("auctiontype"));
                item.setDescription(rs.getString("description"));
                item.setStartPrice(rs.getDouble("startPrice"));
                item.setShippingTime(rs.getString("shippingTime"));
                item.setEndDate(rs.getDate("endDate"));
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
    public void create(Item item) {
        String sql = "INSERT INTO students(itemName,auctionType,description,startPrice,shippingTime,endDate) VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getItemName());
            pstmt.setString(2, item.getAuctionType());
            pstmt.setString(3, item.getDescription());
            pstmt.setDouble(4, item.getStartPrice());
            pstmt.setString(5, item.getShippingTime());
            pstmt.setDate(6, (Date) item.getEndDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Item read(Long itemId){
        String sql = "SELECT itemName,auctionType,description,startPrice,shippingTime,endDate FROM students WHERE itemId = ?";
        Item item = null;
        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, itemId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    item = new Item();
                    item.setItemId(itemId);
                    item.setItemName(rs.getString("itemName"));
                    item.setAuctionType(rs.getString("auctionType"));
                    item.setDescription(rs.getString("description"));
                    item.setStartPrice(rs.getDouble("startPrice"));
                    item.setShippingTime(rs.getString("shippingTime"));
                    item.setEndDate(rs.getDate("endDate"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return item;
    }
    public void update(Long itemId,Item item){
        String sql = "UPDATE students SET itemName = ?, auctionType = ?, desciption = ?,startPrice = ?,shippingTime = ?,endDate = ? WHERE itemId = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getItemName());
            pstmt.setString(2, item.getAuctionType());
            pstmt.setString(3, item.getDescription());
            pstmt.setDouble(4, item.getStartPrice());
            pstmt.setString(5, item.getShippingTime());
            pstmt.setDate(6, (Date) item.getEndDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public void delete(Long itemId){
        String sql = "DELETE FROM students WHERE itemId = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, itemId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    }







