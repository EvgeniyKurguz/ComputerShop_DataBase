package com.epam.kurguz.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Client extends User {

    private String email;
    private String city;
    private String country;
    private List<Client> clientList = new ArrayList<>();

    public Client() {


    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    private Client(int id,
                   String firstName,
                   String lastName,
                   Date birth,
                   String phone,
                   String username,
                   String password,
                   String email,
                   String city,
                   String country) {
        super(id, firstName, lastName, birth, phone, username, password, email);
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + getId() +
                ", firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", phone=" + getPhone() +
                ", birth=" + getBirth() +
                ", email=" + email + '}' + "\n" +
                ", username='" + getUserName() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", city=" + getCity() + '\'' +
                ", country=" + getCountry() + '\'' +
                '}';
    }

    public void setBirth(Date date) {
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private Date birth;
        private String phone;
        private String username;
        private String password;
        private String email;
        private String city;
        private String country;
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


        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder birth(Date birth) {
            this.birth = birth;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
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

        public Client build() {
            return new Client(id,
                    firstName,
                    lastName,
                    birth,
                    phone,
                    username,
                    password,
                    email,
                    city,
                    country);
        }
    }
}




