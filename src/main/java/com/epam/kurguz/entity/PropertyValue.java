package com.epam.kurguz.entity;

public class PropertyValue extends BaseEntity {
    private String name;
    private String value;//добавляет сущность хранящую список значений - values.

    //все доступные знач-я
    public PropertyValue() {
    }

    public PropertyValue(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public PropertyValue(int id, String name, String value) {
        super(id);
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public static class Builder extends PropertyValue {
        private int id;
        private String name;
        private String value;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public PropertyValue build() {
            return new PropertyValue(id,
                    name,
                    value);
        }
    }
}