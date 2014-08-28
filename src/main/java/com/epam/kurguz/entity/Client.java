package com.epam.kurguz.entity;

public class Client extends User {

    private String email;

    public Client() {

    }

    public Client(int id,
                  String firstName,
                  String lastName,
                  String birth,
                  String phone,
                  String username,
                  String password,
                  String email) {
        super(id, firstName, lastName, birth, phone, username, password);
        this.email = email;
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
                ", email=" + email + '}' + "\n";
    }

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String birth;
        private String phone;
        private String attestation_Number;
        private String username;
        private String password;

        private String email;

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

        public Builder birth(String birth) {
            this.birth = birth;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder attestation_Number(String attestation_Number) {
            this.attestation_Number = attestation_Number;
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

        public Client build() {
            return new Client(id, firstName, lastName, birth, phone,  username, password, email);
        }
    }
}




