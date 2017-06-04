package com.andrey.shop.service;

import com.andrey.shop.dao.OrderrDao;
import com.andrey.shop.model.Orderr;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderrServiceImpl implements OrderrService {
    private OrderrDao orderrDao;

    public void setOrderrDao(OrderrDao productDao) {
        this.orderrDao = productDao;
    }

    @Override
    @Transactional
    public void addClient(Orderr book) {
        this.orderrDao .addClient(book);
    }

    @Override
    @Transactional
    public void updateClient(Orderr book) {
        this.orderrDao .updateClient(book);
    }

    @Override
    @Transactional
    public void removeClient(int id) {
        this.orderrDao .removeClient(id);
    }

    @Override
    @Transactional
    public Orderr getClientById(int id) {
        return this.orderrDao .getClientById(id);
    }

    @Override
    @Transactional
    public List<Orderr> listClients() {
        return this.orderrDao .listClients();
    }
}
