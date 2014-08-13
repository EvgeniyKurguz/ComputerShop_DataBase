package com.epam.kurguz.entity;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User {

    private String city;
    private String region;
    private String country;
    private String post;
    private String separation;
    private List<Employee> employees = new ArrayList<Employee>();

    public Employee(int id, String firstName, String lastName, String identityPapers, String phone) {
        super(id, firstName, lastName, identityPapers, phone);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSeparation() {
        return separation;
    }

    public void setSeparation(String separation) {
        this.separation = separation;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
