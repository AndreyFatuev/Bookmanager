package com.andrey.shop.service;

import com.andrey.shop.model.Orderr;

import java.util.List;

public interface OrderrService {
    public void addClient(Orderr book);

    public void updateClient(Orderr book);

    public void removeClient(int id);

    public Orderr getClientById(int id);

    public List<Orderr> listClients();
}
