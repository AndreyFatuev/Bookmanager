package com.andrey.shop.dao;

import com.andrey.shop.model.Orderr_product;

import java.util.List;

public interface Orderr_productDao {
    public void addClient(Orderr_product book);

    public void updateClient(Orderr_product book);

    public void removeClient(int id);

    public Orderr_product getClientById(int id);

    public List<Orderr_product> listClients();
}
