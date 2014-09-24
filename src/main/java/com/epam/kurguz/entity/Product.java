package com.epam.kurguz.entity;

import java.util.ArrayList;
import java.util.List;

public class Product extends BaseEntity {

    private String name;
    private String maker;
    private String model;

    List<Product> productList = new ArrayList<Product>();

    public Product() {
    }

    public Product(int id) {
        super(id);
    }

    public Product(int id, String name, String maker, String model) {
        this.name = name;
        this.maker = maker;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public static class Builder extends Product {
        private int id;
        private String name;
        private String maker;
        private String model;


        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder maker(String maker) {
            this.maker = maker;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Product build() {
            return new Product(id,
                    name,
                    maker,
                    model);
        }

        ;
    }


}