package com.codejava.service.implement;

import com.codejava.entities.Category;
import com.codejava.repository.CategoryRepository;
import com.codejava.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository repo;


	@Override
	public List<Category> findAll() {
		return repo.findAll();
	}

	@Override
	public void saveCategory(Category category) {
		if (category != null){
			Category cate = null;
			if (category.getId() != null){
				cate = repo.getById(category.getId());
			} else if (cate == null){
				cate = new Category();
			}
			cate.setName(category.getName());
			cate.setBrand(category.getBrand());
			repo.save(cate);
		}
	}

	@Override
	public Category findById(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
