package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.vo.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    private CategoryDao categoryDaoImple;

    public CategoryServiceImpl(CategoryDao categoryDaoImple){
        this.categoryDaoImple = categoryDaoImple;
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryDaoImple.getCategoryById(id);
    }

    @Override
    public List<Category> getCategories() {
        return categoryDaoImple.getCategories();
    }
}
