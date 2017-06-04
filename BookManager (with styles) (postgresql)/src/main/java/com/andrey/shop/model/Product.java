package com.andrey.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "ARTICUL")
    private int articul;

    @Column(name = "PRODUCT_NAME")
    private String product_name;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "PICTURE")
    private String picture;

    public Product() {
    }

    public Product(Integer articul, String product_name, Integer price, String picture) {
        this.articul = articul;
        this.product_name = product_name;
        this.price = price;
        this.picture = picture;
    }

/*    @OneToMany(mappedBy="product", orphanRemoval=true, cascade=CascadeType.ALL)
    protected List<Orderr_product> orderr_products;*/

    public int getArticul() {
        return articul;
    }
    public void setArticul(int articul) {
        this.articul = articul;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getPicture() {
        return picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "articul=" + articul  +
                ", product_name='" + product_name + '\'' +
                ", price='" + price + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
