package com.codejava.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String name;

    @Column
    private float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public List<ProductDetails> getDetails() {
        return details;
    }

    public void setDetails(List<ProductDetails> details) {
        this.details = details;
    }

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductDetails> details = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addDetail(String detailName, String detailValue) {
        this.details.add(new ProductDetails(detailName, detailValue, this));
    }

    public void setDetail(Integer id, String name, String value){
        this.details.add(new ProductDetails(id, name, value, this));
    }
}
