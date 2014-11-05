package com.thoughtworks.iamcoach.pos.util;


import com.thoughtworks.iamcoach.pos.vo.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;

public class CategoryRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getString("id"));
        category.setName(resultSet.getString("name"));
        return category;
    }
}
