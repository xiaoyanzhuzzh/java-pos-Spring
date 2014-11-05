package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.ConnectionUtil;
import com.thoughtworks.iamcoach.pos.util.ItemRowMapper;
import com.thoughtworks.iamcoach.pos.util.PomotionRowMapper;
import com.thoughtworks.iamcoach.pos.vo.*;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.*;
import java.util.*;

public class ItemDaoImple implements ItemDao {

//    ConnectionUtil connectionUtil = new ConnectionUtil();
//    private PreparedStatement prepareStatement = null;
//    private ResultSet rs = null;
    SimpleJdbcTemplate simpleJdbcTemplate;
    public ItemDaoImple(SimpleJdbcTemplate simpleJdbcTemplate){
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    @Override
    public Item getItemByBarcode(String barcode){
        String sql = "SELECT * FROM items WHERE barcode = ?";

        return (Item) simpleJdbcTemplate.queryForObject(sql, new ItemRowMapper(), barcode);
//        Item item = null;
//        Connection conn = connectionUtil.getConnection();
//        try{
//            prepareStatement = conn.prepareStatement(sql);
//            prepareStatement.setString(1, barcode);
//            rs = prepareStatement.executeQuery();
//            rs.next();
//
//            item = new Item(rs.getString("id"),
//                    rs.getString("barcode"),
//                    rs.getString("name"),
//                    rs.getString("unit"),
//                    rs.getDouble("price"),
//                    rs.getString("categoryId")
//            );
//            rs.close();
//            prepareStatement.close();
//            connectionUtil.closeConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return item;
    }

    @Override
    public List<Item> getItems() {
        String sql = "SELECT * FROM items ";
        return simpleJdbcTemplate.query(sql, new ItemRowMapper());
//        Connection connection = connectionUtil.getConnection();
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//            rs = statement.executeQuery(sql);
//            while(rs.next()){
//                items.add(new Item(
//                        rs.getString("id"),
//                        rs.getString("barcode"),
//                        rs.getString("name"),
//                        rs.getString("unit"),
//                        rs.getDouble("price"),
//                        rs.getString("categoryId")
//                ));
//
//            }
//            rs.close();
//            statement.close();
//            connectionUtil.closeConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return items;
    }

    @Override
    public List<Promotion> getPromotionsByItemId(String id) {
        List<Promotion> promotions = new ArrayList<Promotion>();
        String sql = "SELECT promotions.*, items_promotions.discount FROM promotions, items_promotions " +
                "WHERE items_promotions.itemId=? AND promotions.id=items_promotions.proId";
        return simpleJdbcTemplate.queryForObject(sql, new PomotionRowMapper(), id);
//        Connection connection = connectionUtil.getConnection();
//        ResultSet rs = null;
//
//        try {
//            prepareStatement = connection.prepareStatement(sql);
//            prepareStatement.setString(1, id);
//
//            rs = prepareStatement.executeQuery();
//            while(rs.next()){
//                Promotion promotion = PromotionFactory.getPromotionByType(rs.getInt("type"));
//
//                promotion.setId(rs.getString("id"));
//                promotion.setType(rs.getInt("type"));
//                promotion.setProDesc(rs.getString("proDesc"));
//                promotion.setDiscount(rs.getDouble("discount"));
//
//                promotions.add(promotion);
//            }
//
//            rs.close();
//            prepareStatement.close();
//            connectionUtil.closeConnection();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return promotions;
    }
}
