package com.codejava.service.implement;

import com.codejava.entities.Product;
import com.codejava.repository.ProductRepository;
import com.codejava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repo;

    @Override
    public List<Product> findAllProduct() {
        return repo.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        repo.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
