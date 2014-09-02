package com.epam.kurguz.entity;

import java.util.Date;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private Date birth;
    private String identityPapers;
    private String phone;
    private String userName;
    private String password;
    private String email;

    public User(String username, String password) {
    }

    public User(String username) {
        this.userName = userName;
    }

    public User(int id, String firstName, String lastName, String userName, String password,  Date birth,  String identityPapers, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityPapers = identityPapers;
        this.phone = phone;
        this.email = email;
        this.identityPapers = identityPapers;
        this.birth = birth;
        this.userName = userName;
        this.password = password;
    }

    public User(int id, String firstName, String lastName, Date birth, String phone, String username, String password, String email) {
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getIdentityPapers() {
        return identityPapers;
    }

    public void setIdentityPapers(String passport) {
        this.identityPapers = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
