package com.andrey.shop.service;

import com.andrey.shop.model.Product;

import java.util.List;

public interface ProductService {
    public void addClient(Product book);

    public void updateClient(Product book);

    public void removeClient(int id);

    public Product getClientById(int id);

    public List<Product> listClients();
}
