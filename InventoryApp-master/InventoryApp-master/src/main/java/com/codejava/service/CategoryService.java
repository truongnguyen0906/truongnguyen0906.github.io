package com.codejava.service;

import com.codejava.entities.Category;

import java.util.List;

public interface CategoryService {
	public List<Category> findAll();
	public void saveCategory(Category category);
	public Category findById(Integer id);
	public void delete(Integer id);
}
