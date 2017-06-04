package com.andrey.shop.dao;

import com.andrey.shop.model.Orderr_product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class Orderr_productDaoImpl implements Orderr_productDao {

    private static final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addClient(Orderr_product book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Orderr_product successfully saved. Orderr_product details: " + book);
    }

    @Override
    public void updateClient(Orderr_product book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Orderr_product successfully update. Orderr_product details: " + book);
    }

    @Override
    public void removeClient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Orderr_product book = (Orderr_product) session.load(Orderr_product.class, new Integer(id));
        if(book!=null){
            session.delete(book);
        }
        logger.info("Orderr_product successfully removed. Orderr_product details: " + book);
    }

    @Override
    public Orderr_product getClientById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Orderr_product book = (Orderr_product) session.load(Orderr_product.class, new Integer(id));
        logger.info("Orderr_product successfully loaded. Orderr_product details: " + book);
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Orderr_product> listClients() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Orderr_product> bookList = session.createQuery("from Orderr_product").list();
        for(Orderr_product book: bookList){
            logger.info("Orderr_product list: " + book);
        }
        return bookList;
    }
}
