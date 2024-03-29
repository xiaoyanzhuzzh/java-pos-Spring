package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.*;
import com.thoughtworks.iamcoach.pos.vo.*;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.*;

public class ItemDaoImpl implements ItemDao {

    SimpleJdbcTemplate simpleJdbcTemplate;
    public ItemDaoImpl(SimpleJdbcTemplate simpleJdbcTemplate){
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    @Override
    public Item getItemByBarcode(String barcode){
        String sql = "SELECT * FROM items WHERE barcode = ?";
        return (Item) simpleJdbcTemplate.queryForObject(sql, new ItemRowMapper(), barcode);
    }

    @Override
    public List<Item> getItems() {
        String sql = "SELECT * FROM items ";
        return simpleJdbcTemplate.query(sql, new ItemRowMapper());
    }

    @Override
    public List<Promotion> getPromotionsByItemId(String id) {
        String sql = "SELECT promotions.*, items_promotions.discount FROM promotions, items_promotions " +
                "WHERE items_promotions.itemId=? AND promotions.id=items_promotions.proId";
        return (List<Promotion>) simpleJdbcTemplate.query(sql, new PromotionRowMapper(), id);
    }
}
