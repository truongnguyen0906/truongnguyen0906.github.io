package com.codejava.controller;

import com.codejava.entities.Brand;
import com.codejava.entities.Category;
import com.codejava.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("")
	public String listCategories(Model model) {
		List<Category> listCategoryList = categoryService.findAll();
		model.addAttribute("listCategoryList", listCategoryList);
		return "categories";
	}

	@GetMapping("/new")
	public String showCategoryNewForm(Model model){
		model.addAttribute("category", new Category());

		return "category_form";
	}

	@PostMapping("/save")
	public String saveCategory(Category category){
		categoryService.saveCategory(category);
		return "redirect:/categories";
	}

	@GetMapping("/edit/{id}")
	public String showEditProductForm(@PathVariable("id") Integer id, Model model){
		Category category = categoryService.findById(id);

		model.addAttribute("category", category);
		return "category_form";
	}

	@GetMapping("/delete/{id}")
	public String deleteProductForm(@PathVariable("id") Integer id){
		categoryService.delete(id);
		return "redirect:/categories";
	}
}
