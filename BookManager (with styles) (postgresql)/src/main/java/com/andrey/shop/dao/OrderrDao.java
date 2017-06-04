package com.andrey.shop.dao;

import com.andrey.shop.model.Orderr;

import java.util.List;

public interface OrderrDao {
    public void addClient(Orderr book);

    public void updateClient(Orderr book);

    public void removeClient(int id);

    public Orderr getClientById(int id);

    public List<Orderr> listClients();
}
