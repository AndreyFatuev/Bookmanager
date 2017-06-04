package com.andrey.shop.model;

/**
 * Created by Андрей on 01.05.2017.
 */


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ORDERR_PRODUCT")
public class Orderr_product {

    @Id
    @Column(name = "ID_ORDERR_PRODUCT")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id_orderr_product;

    @Column(name = "ID_ORDERR")
    private Integer id_orderr;

    @Column(name = "ARTICUL")
    private Integer articul;

    @Column(name = "AMOUNT")
    private Integer amount;

    public Orderr_product() {
    }

    public Orderr_product(Integer id_orderr, Integer articul, Integer amount) {
        this.id_orderr = id_orderr;
        this.articul = articul;
        this.amount = amount;
    }

/*    @ManyToOne
    protected Orderr orderr;
    @ManyToOne
    protected Product product;*/

    public int getId_orderr_product() {
        return id_orderr_product;
    }
    public void setId_orderr_product(int id_orderr_product) {
        this.id_orderr_product = id_orderr_product;
    }
    public Integer getId_orderr() {
        return id_orderr;
    }
    public void setId_orderr(Integer id_orderr) {
        this.id_orderr = id_orderr;
    }
    public Integer getArticul() {
        return articul;
    }
    public void setArticul(Integer articul) {
        this.articul = articul;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Orderr_product{" +
                "id_orderr_product" + id_orderr_product +
                "id_orderr=" + id_orderr +
                ", articul='" + articul + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
