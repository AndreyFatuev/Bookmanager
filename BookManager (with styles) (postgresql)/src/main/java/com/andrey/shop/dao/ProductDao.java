package com.andrey.shop.dao;

import com.andrey.shop.model.Product;

import java.util.List;

public interface ProductDao {
    public void addClient(Product book);

    public void updateClient(Product book);

    public void removeClient(int id);

    public Product getClientById(int id);

    public List<Product> listClients();
}
