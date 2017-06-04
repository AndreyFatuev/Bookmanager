package com.andrey.shop.dao;

import com.andrey.shop.model.Client;

import java.util.List;

public interface ClientDao {

    //@Query(value = "SELECT b FROM Book b WHERE b.title = 'Land of Lisp'")
    //List<Book> findHoge();

    public void addClient(Client book);

    public void updateClient(Client book);

    public void removeClient(int id);

    public Client getClientById(int id);

    public List<Client> listClients();


}
