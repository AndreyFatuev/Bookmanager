package com.andrey.shop.dao;

import java.util.List;

import com.andrey.shop.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Repository
public class ClientDaoImpl implements ClientDao {

    private static final Logger logger = LoggerFactory.getLogger(ClientDaoImpl.class);
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedTemplate;
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void addClient(Client book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book successfully saved. Book details: " + book);
    }

    @Override
    public void updateClient(Client book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book successfully update. Book details: " + book);
    }

    @Override
    public void removeClient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Client book = (Client) session.load(Client.class, new Integer(id));
        if(book!=null){
            session.delete(book);
        }
        logger.info("Book successfully removed. Book details: " + book);
    }

    @Override
    public Client getClientById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Client book = (Client) session.load(Client.class, new Integer(id));
        logger.info("Book successfully loaded. Book details: " + book);
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Client> listClients() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Client> bookList = session.createQuery("from Client").list();
        for(Client book: bookList){
            logger.info("Book list: " + book);
        }
        return bookList;
    }
}
