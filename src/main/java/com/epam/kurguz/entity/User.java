package com.epam.kurguz.entity;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String identityPapers;
    private String phone;

    public User() {
    }

    public User(int id, String firstName, String lastName, String identityPapers, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityPapers = identityPapers;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return identityPapers;
    }

    public void setPassport(String passport) {
        this.identityPapers = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
