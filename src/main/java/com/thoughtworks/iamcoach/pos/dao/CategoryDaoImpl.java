package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.util.CategoryRowMapper;
import com.thoughtworks.iamcoach.pos.vo.Category;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class CategoryDaoImpl implements CategoryDao {
    private final SimpleJdbcTemplate simpleJdbcTemplate;

    public CategoryDaoImpl(SimpleJdbcTemplate simpleJdbcTemplate){
        this.simpleJdbcTemplate = simpleJdbcTemplate;
    }

    @Override
    public Category getCategoryById(String id) {
        String sql = "SELECT * FROM categories WHERE id = ?";
        return (Category)simpleJdbcTemplate.queryForObject(sql, new CategoryRowMapper(), id);
    }

//    @Override
//    public List<Category> getCategories() {
//        return null;
//    }
}
