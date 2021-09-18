package com.codejava.controller;

import com.codejava.entities.Category;
import com.codejava.entities.Product;
import com.codejava.service.CategoryService;
import com.codejava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/new")
    public String showNewProductForm(Model model){
        List<Category> categoryList = categoryService.findAll();

        model.addAttribute("product", new Product());
        model.addAttribute("categoryList", categoryList);

        return "product_form";
    }

    @PostMapping("/save")
    public String saveProduct(Product product, HttpServletRequest req){
        String[] detailIDs = req.getParameterValues("detailID");
        String[] detailNames = req.getParameterValues("detailName");
        String[] detailValues = req.getParameterValues("detailValue");

        for (int i = 0; i < detailNames.length; i++) {
            if (detailIDs != null && detailIDs.length > 0){
                product.setDetail(Integer.valueOf(detailIDs[i]), detailNames[i], detailValues[i]);
            } else {
                product.addDetail(detailNames[i], detailValues[i]);
            }
        }
        productService.saveProduct(product);

        return "redirect:/products";
    }

    @GetMapping("")
    public String listProducts(Model model){
        List<Product> productList = productService.findAllProduct();

        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model){
        Product product = productService.findById(id);
        List<Category> categoryList = categoryService.findAll();

        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryList);

        return "product_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductForm(@PathVariable("id") Integer id){
        productService.delete(id);

        return "redirect:/products";
    }

}
