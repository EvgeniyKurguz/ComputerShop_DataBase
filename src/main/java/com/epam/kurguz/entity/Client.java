package com.epam.kurguz.entity;

public class Client extends User {

    private String email;

    public Client(int id,
                  String firstName,
                  String lastName,
                  String birth,
                  String phone,
                  String identityPapers,
                  String username,
                  String password,
                  String email) {
        super(id, firstName, lastName, birth, identityPapers, phone, username, password);
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
}

