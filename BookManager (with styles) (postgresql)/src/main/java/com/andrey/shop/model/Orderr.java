package com.andrey.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "ORDERR")
public class Orderr {

    @Id
    @Column(name = "ID_ORDERR")
    //@GeneratedValue(generator = "increment")
    //@GenericGenerator(name = "increment", strategy = "increment")
    private int id_orderr;

    @Column(name = "ID_CLIENT")
    private Integer id_client;

    @Column(name = "DATE")
    private String date;

    public Orderr() {
    }

    public Orderr(Integer id_orderr, Integer id_client, String date) {
        this.id_orderr = id_orderr;
        this.id_client = id_client;
        this.date = date;
    }

/*
    @ManyToOne
    protected Client client;

    @OneToMany(mappedBy="orderr", orphanRemoval=true, cascade=CascadeType.ALL)
    protected List<Orderr_product> orderr_products;*/

    public int getId_orderr() {
        return id_orderr;
    }
    public void setId_orderr(int id_orderr) {
        this.id_orderr = id_orderr;
    }
    public Integer getId_client() {
        return id_client;
    }
    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Orderr{" +
                "id_orderr=" + id_orderr +
                ", id_client='" + id_client + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
