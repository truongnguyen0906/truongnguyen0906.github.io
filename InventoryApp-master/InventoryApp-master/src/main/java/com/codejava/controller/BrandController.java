package com.codejava.controller;

import com.codejava.entities.Brand;
import com.codejava.entities.Category;
import com.codejava.entities.Product;
import com.codejava.service.BrandService;
import com.codejava.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String listBrand(Model model){
        List<Brand> brandList = brandService.findAll();
        model.addAttribute("brandList", brandList);
        return "brands";
    }

    @GetMapping("/new")
    public String showBrandNewForm(Model model){
        List<Category> categoryList = categoryService.findAll();

        model.addAttribute("brand", new Brand());
        model.addAttribute("categoryList", categoryList);
        return "brand_form";
    }

    @PostMapping("/save")
    public String saveBrand(Brand brand){
        brandService.save(brand);

        return "redirect:/brands";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model){
        List<Category> categoryList = categoryService.findAll();
        Brand brand = brandService.findById(id);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("brand", brand);

        return "brand_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductForm(@PathVariable("id") Integer id){
        brandService.delete(id);

        return "redirect:/brands";
    }
}
