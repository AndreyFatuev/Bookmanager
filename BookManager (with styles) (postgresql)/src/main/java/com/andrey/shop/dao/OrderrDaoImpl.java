package com.andrey.shop.dao;

import com.andrey.shop.model.Orderr;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class OrderrDaoImpl implements OrderrDao {

    private static final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addClient(Orderr book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Orderr successfully saved. Orderr details: " + book);
    }

    @Override
    public void updateClient(Orderr book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Orderr successfully update. Orderr details: " + book);
    }

    @Override
    public void removeClient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Orderr book = (Orderr) session.load(Orderr.class, new Integer(id));
        if(book!=null){
            session.delete(book);
        }
        logger.info("Orderr successfully removed. Orderr details: " + book);
    }

    @Override
    public Orderr getClientById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Orderr book = (Orderr) session.load(Orderr.class, new Integer(id));
        logger.info("Orderr successfully loaded. Orderr details: " + book);
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Orderr> listClients() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Orderr> bookList = session.createQuery("from Orderr").list();
        for(Orderr book: bookList){
            logger.info("Orderr list: " + book);
        }
        return bookList;
    }
}
