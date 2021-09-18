package com.codejava.service;

import com.codejava.entities.Category;
import com.codejava.entities.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProduct();
    public void saveProduct(Product product);
    public Product findById(Integer id);
    public void delete(Integer id);
}
