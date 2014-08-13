package com.epam.kurguz.entity;

import com.epam.kurguz.dao.Identified;

import java.util.ArrayList;
import java.util.List;

public class Client extends User implements Identified<Integer> {

    private String email;
    private List<Client> clients = new ArrayList<Client>();

    public Client() {
    }

    public Client(int id, String firstName, String lastName, String identityPapers, String phone) {
        super(id, firstName, lastName, identityPapers, phone);
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