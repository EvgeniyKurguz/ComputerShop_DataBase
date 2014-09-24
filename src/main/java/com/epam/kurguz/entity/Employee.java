package com.epam.kurguz.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Employee extends User {
    private String separation;

    public Employee() {
    }

    public Employee(int id) {
        super(id);
    }

    public Employee(int id, String firstName, String lastName, Date birth, String phone, String attestationNumber, String username, String password, String email, Role role,  BigDecimal account, String separation, boolean blocked) {
        super(id, firstName, lastName, birth, phone, attestationNumber, username, password, email, role,  account, blocked);
        this.separation = separation;
    }

    public String getSeparation() {
        return separation;
    }

    public void setSeparation(String separation) {
        this.separation = separation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", birth=" + getBirth() +
                ", phone='" + getPhone() + '\'' +
                ", attestationNumber='" + getAttestationNumber() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", role=" + getRole() +'\'' +
                ", account" + getAccount() + '\'' +
                "separation='" + separation + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
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
        private String separation;
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

        public Builder birth(Date birth) {
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

        public Builder separation(String separation) {
            this.separation = separation;
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

        public Employee build() {
            return new Employee(id,
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
                    separation,
                    blocked);
        }
    }
}
