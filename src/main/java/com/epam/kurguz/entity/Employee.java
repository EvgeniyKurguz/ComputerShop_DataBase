package com.epam.kurguz.entity;

import java.util.Date;

public class Employee extends User {
    private String separation;

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, Date birth, String phone, String username, String password, String email, String separation) {
        super(username, password);
    }

    public Employee(int id,
                    String firstName,
                    String lastName,
                    Date birth,
                    String phone,
                    String attestation_number,
                    String username,
                    String password,
                    String email,

                    String separation) {
        super(id, firstName, lastName, birth, phone,  username, password, email);
        this.separation = separation;
    }

    public String getSeparation() {
        return separation;
    }

    public void setSeparation(String separation) {
        this.separation = separation;
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

        private String separation;

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

        public Builder separation(String separation) {
            this.separation = separation;
            return this;
        }

        public Employee build() {
            return new Employee(id,
                    firstName,
                    lastName,
                    birth,
                    phone,
                    username,
                    password,
                    email,
                    separation);
        }
    }
}
