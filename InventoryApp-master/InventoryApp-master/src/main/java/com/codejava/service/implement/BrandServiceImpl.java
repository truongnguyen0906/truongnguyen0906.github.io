package com.codejava.service.implement;

import com.codejava.entities.Brand;
import com.codejava.repository.BrandRepository;
import com.codejava.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository repo;

    @Override
    public List<Brand> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(Brand brand) {
        repo.save(brand);
    }

    @Override
    public Brand findById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
