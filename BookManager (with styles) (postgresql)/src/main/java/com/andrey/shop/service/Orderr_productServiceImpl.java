package com.andrey.shop.service;

import com.andrey.shop.dao.Orderr_productDaoImpl;
        import com.andrey.shop.model.Orderr_product;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;

@Service
public class Orderr_productServiceImpl implements Orderr_productService {
    private Orderr_productDaoImpl orderr_productDaoo;

    public void setOrderr_productDaoo(Orderr_product orderr_productDao) {
        this.orderr_productDaoo = orderr_productDaoo; }

    @Override
    @Transactional
    public void addClient(Orderr_product book) {
        this.orderr_productDaoo.addClient(book);
    }

    @Override
    @Transactional
    public void updateClient(Orderr_product book) {
        this.orderr_productDaoo.updateClient(book);
    }

    @Override
    @Transactional
    public void removeClient(int id) {
        this.orderr_productDaoo.removeClient(id);
    }

    @Override
    @Transactional
    public Orderr_product getClientById(int id) {
        return this.orderr_productDaoo.getClientById(id);
    }

    @Override
    @Transactional
    public List<Orderr_product> listClients() {
        return this.orderr_productDaoo.listClients();
    }

    public void setOrderr_productDaoo(Orderr_productDaoImpl orderr_productDaoo) {
        this.orderr_productDaoo = orderr_productDaoo;
    }

    public Orderr_productDaoImpl getOrderr_productDaoo() {
        return orderr_productDaoo;
    }
}
