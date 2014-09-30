package com.epam.kurguz.entity;

import java.math.BigDecimal;
import java.util.List;

public class Product extends BaseEntity {

    private String name;
    private String maker;
    private String model;
    private int weight;
    private int quantity;
    private BigDecimal price;
    private List<PropertyValue> propertyValueList;
    private boolean blocked;

    public Product() {
    }

    public Product(int id) {
        super(id);
    }

    public Product(int id, String name, String maker, String model, BigDecimal price, int weight, int quantity, boolean blocked) {
        super(id);
        this.name = name;
        this.maker = maker;
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
        this.blocked = blocked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

    public void setPropertyValueList(List<PropertyValue> propertyValueList) {
        this.propertyValueList = propertyValueList;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
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
                "name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                ", quantity=" + quantity +
                ", price=" + price +
                ", propertyValueList=" + propertyValueList +
                ", blocked=" + blocked +
                '}';
    }

    public static class Builder extends Product {
        private int id;
        private String name;
        private String maker;
        private String model;
        private int weight;
        private int quantity;
        private BigDecimal price;
        private List<PropertyValue> propertyValueList;
        private boolean blocked;


        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder propertyList(List<PropertyValue> propertyValueList) {
            this.propertyValueList = propertyValueList;
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

        public Builder blocked(boolean blocked) {
            this.blocked = blocked;
            return this;
        }

        public Product build() {
            return new Product(id,
                    name,
                    maker,
                    model,
                    price,
                    weight,
                    quantity,
                    blocked);
        };
    }


}