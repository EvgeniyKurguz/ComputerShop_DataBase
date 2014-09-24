package com.epam.kurguz.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private String city;
    private String country;
    private List<Client> clientList = new ArrayList<>();

    public Client() {
    }

    public Client(int id) {
        super(id);
    }

    public Client(int id, String firstName, String lastName, java.util.Date birth, String phone, String attestationNumber, String username, String password, String email, Role role, BigDecimal account, String city, String country,  boolean blocked) {
        super(id, firstName, lastName, birth, phone, attestationNumber, username, password, email, role, account, blocked);
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", birth=" + getBirth() +
                ", phone='" + getPhone() + '\'' +
                ", attestationNumber='" + getAttestationNumber() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", role=" + getRole() + '\'' +
                ", account=" + getAccount() + '\'' +
                ", city=" + getCity() + '\'' +
                ", country=" + getCountry() + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static class Builder extends Client {
        private int id;
        private String firstName;
        private String lastName;
        private java.util.Date birth;
        private String phone;
        private String attestationNumber;
        private String username;
        private String password;
        private Role role;
        private String email;
        private String city;
        private String country;
        private BigDecimal account;
        private boolean blocked;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder birth(java.util.Date birth) {
            this.birth = birth;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder attestationNumber(String attestationNumber) {
            this.attestationNumber = attestationNumber;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder account(BigDecimal account) {
            this.account = account;
            return this;
        }

        public Builder blocked(boolean blocked) {
            this.blocked = blocked;
            return this;
        }

        public Client build() {
            return new Client(id,
                    firstName,
                    lastName,
                    birth,
                    phone,
                    attestationNumber,
                    username,
                    password,
                    email,
                    role,
                    account,
                    city,
                    country,
                    blocked);
        }
    }
}

