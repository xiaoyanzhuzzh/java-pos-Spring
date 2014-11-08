package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.vo.Category;

public class CategoryServiceImpl implements CategoryService{
    private CategoryDao categoryDaoImpl;

    public CategoryServiceImpl(CategoryDao categoryDaoImpl){
        this.categoryDaoImpl = categoryDaoImpl;
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryDaoImpl.getCategoryById(id);
    }

//    @Override
//    public List<Category> getCategories() {
//        return categoryDaoImple.getCategories();
//    }
}
