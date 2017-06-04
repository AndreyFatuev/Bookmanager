package com.andrey.shop.service;

import com.andrey.shop.dao.ClientDao;
import com.andrey.shop.model.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;

    public void setBookDao(ClientDao bookDao) {
        this.clientDao = bookDao;
    }

    @Override
    @Transactional
    public void addClient(Client book) {
        this.clientDao.addClient(book);
    }


    @Override
    @Transactional
    public void updateClient(Client book) {
        this.clientDao.updateClient(book);
    }

    @Override
    @Transactional
    public void removeClient(int id) {
        this.clientDao.removeClient(id);
    }

    @Override
    @Transactional
    public Client getClientById(int id) {
        return this.clientDao.getClientById(id);
    }

    @Override
    @Transactional
    public List<Client> listClients() {
        return this.clientDao.listClients();
    }
}
