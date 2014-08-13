package com.epam.kurguz.entity;

import java.util.ArrayList;
import java.util.List;

public class Client extends User{

    private String email;
    private List<Client> clients = new ArrayList<Client>();

    public Client() {
    }

    public Client(int id, String firstName, String lastName, String passport, String phone) {
        super(id, firstName, lastName, passport, phone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}