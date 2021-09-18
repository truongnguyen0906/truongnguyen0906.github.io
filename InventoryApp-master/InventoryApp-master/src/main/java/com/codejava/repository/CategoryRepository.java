package com.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codejava.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
