package com.thoughtworks.iamcoach.pos.dao;

import com.thoughtworks.iamcoach.pos.vo.Category;

public interface CategoryDao {
    Category getCategoryById(String id);
//    List<Category> getCategories();
}
