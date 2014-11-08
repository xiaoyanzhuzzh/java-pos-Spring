package com.thoughtworks.iamcoach.pos.util;

import com.thoughtworks.iamcoach.pos.vo.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;

public class PromotionRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Promotion promotion = PromotionFactory.getPromotionByType(resultSet.getInt("type"));
        promotion.setId(resultSet.getString("id"));
        promotion.setProDesc(resultSet.getString("proDesc"));
        promotion.setType(resultSet.getInt("type"));
        promotion.setDiscount(resultSet.getDouble("discount"));
        return promotion;
    }
}
