package com.codejava.service;

import com.codejava.entities.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> findAll();
    public void save(Brand brand);
    public Brand findById(Integer id);
    public void delete(Integer id);
}
