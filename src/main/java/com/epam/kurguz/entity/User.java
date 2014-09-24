package com.epam.kurguz.entity;

import java.math.BigDecimal;
import java.util.Date;

public abstract class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private Date birth;
    private String phone;
    private String attestationNumber;
    private String username;
    private String password;
    private String email;
    private Role role;

    private BigDecimal account;
    private boolean blocked;

    public User(int id) {
        super(id);
    }

    public User(int id, String firstName, String lastName, Date birth, String phone, String attestationNumber, String username, String password, String email, Role role,  BigDecimal account, boolean blocked) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.phone = phone;
        this.attestationNumber = attestationNumber;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.account = account;
        this.blocked = blocked;
    }

    public User() {
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
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

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getAttestationNumber() {
        return attestationNumber;
    }

    public void setAttestationNumber(String attestationNumber) {
        this.attestationNumber = attestationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", attestationNumber='" + attestationNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", account" + account +
                '}';
    }

    public enum Role {
        CLIENT, EMPLOYEE, ADMIN
    }
}



