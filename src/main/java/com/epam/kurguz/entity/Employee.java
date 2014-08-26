package com.epam.kurguz.entity;

public class Employee extends User {

    private String city;
    private String region;
    private String country;
    private String post;
    private String separation;
    private String identityPapers;

    public Employee(int id,
                    String firstName,
                    String lastName,
                    String birth,
                    String phone,
                    String attestation_Number,
                    String username,
                    String password,

                    String post) {
        super(id, firstName, lastName, birth, phone, attestation_Number, username, password);
        this.post = post;
    }

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

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private String birth;
        private String phone;
        private String attestation_Number;
        private String username;
        private String password;

        private String post;

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

        public Builder post(String post) {
            this.post = post;
            return this;
        }

        public Employee build() {
            return new Employee(id, firstName, lastName, birth, phone, attestation_Number, username, password, post);
        }
    }
}
