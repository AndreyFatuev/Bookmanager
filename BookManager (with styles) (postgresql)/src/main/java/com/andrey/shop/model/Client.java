package com.andrey.shop.model;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @Column(name = "ID_CLIENT")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(name = "CLIENT_NAME")
    private String client_name;

    @Column(name = "CLIENT_CITY")
    private String client_city;

/*
    @OneToMany(mappedBy="client", orphanRemoval=true, cascade=CascadeType.ALL)
    protected List<Orderr> orderrs = new ArrayList<Orderr>();
*/

    public Client() {
    }

    public Client(Integer Id, String client_name, String client_city) {
        this.id = id;
        this.client_name = client_name;
        this.client_city = client_city;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getClient_name() {
        return client_name;
    }
    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }
    public String getClient_city() {
        return client_city;
    }
    public void setClient_city(String client_city) {
        this.client_city = client_city;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id +
                ", client_name='" + client_name + '\'' +
                ", client_city='" + client_city + '\'' +
                '}';
    }
}
