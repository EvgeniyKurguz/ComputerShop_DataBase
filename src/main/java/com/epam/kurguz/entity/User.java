package com.epam.kurguz.entity;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String birth;
    private String identityPapers;
    private String phone;
    private String userName;
    private String password;

    public User(int id, String s, String name, String birth, String firstName, String lastName, String identityPapers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityPapers = identityPapers;
        this.phone = phone;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
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
