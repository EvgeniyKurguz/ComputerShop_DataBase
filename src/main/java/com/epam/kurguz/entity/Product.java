package com.epam.kurguz.entity;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private String name;
    private String maker;
    private String model;

    List<Product> products = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return maker;
    }

    public void setCountry(String country) {
        this.maker = country;
    }

    public String getMaterial() {
        return model;
    }

    public void setMaterial(String material) {
        this.model = material;
    }

}
