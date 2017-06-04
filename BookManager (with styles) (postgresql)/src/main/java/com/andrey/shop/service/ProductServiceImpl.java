package com.andrey.shop.service;

import com.andrey.shop.dao.ProductDao;
import com.andrey.shop.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductDao clientDao;

    public void setProductDao(ProductDao productDao) {
        this.clientDao = productDao;
    }

    @Override
    @Transactional
    public void addClient(Product book) {
        this.clientDao.addClient(book);
    }

    @Override
    @Transactional
    public void updateClient(Product book) {
        this.clientDao.updateClient(book);
    }

    @Override
    @Transactional
    public void removeClient(int id) {
        this.clientDao.removeClient(id);
    }

    @Override
    @Transactional
    public Product getClientById(int id) {
        return this.clientDao.getClientById(id);
    }

    @Override
    @Transactional
    public List<Product> listClients() {
        return this.clientDao.listClients();
    }
}
