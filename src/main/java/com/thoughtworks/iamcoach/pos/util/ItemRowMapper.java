package com.thoughtworks.iamcoach.pos.util;


import com.thoughtworks.iamcoach.pos.vo.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;

public class ItemRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Item item = new Item();
        item.setId(resultSet.getString("id"));
        item.setBarcode(resultSet.getString("barcode"));
        item.setName(resultSet.getString("name"));
        item.setUnit(resultSet.getString("unit"));
        item.setCategoryId(resultSet.getString("categoryId"));
        item.setPrice(resultSet.getDouble("price"));
        return item;
    }
}
