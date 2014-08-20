package com.epam.kurguz.entity;

public class Employee extends User {

    private String city;
    private String region;
    private String country;
    private String post;
    private String separation;
    private String identityPapers;

    public Employee() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIdentityPapers() {
        return identityPapers;
    }

    public void setIdentityPapers(String identityPapers) {
        this.identityPapers = identityPapers;
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
}
