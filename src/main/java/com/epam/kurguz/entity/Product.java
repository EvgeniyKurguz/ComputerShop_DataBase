package com.epam.kurguz.entity;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private String name;
    private String maker;
    private String model;

    List<Product> products = new ArrayList<Product>();

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

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
