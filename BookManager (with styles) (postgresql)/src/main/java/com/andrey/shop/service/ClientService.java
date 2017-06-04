package com.andrey.shop.service;

import com.andrey.shop.model.Client;

import java.util.List;

public interface ClientService {

    public void addClient(Client book);

    public void updateClient(Client book);

    public void removeClient(int id);

    public Client getClientById(int id);

    public List<Client> listClients();



}
