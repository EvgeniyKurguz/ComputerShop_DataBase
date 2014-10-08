package com.epam.kurguz.entity;

public class Country extends BaseEntity {
    private String name;

    public Country() {
    }

    public Country(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static class Builder extends Country {
        private int id;
        private String name;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Country build() {
            return new Country(id,
                    name);
        }
    }
}