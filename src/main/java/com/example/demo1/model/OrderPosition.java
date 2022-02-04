package com.example.demo1.model;

import javax.persistence.*;

@Entity
public class OrderPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Product product;
    private int quantity;

    public OrderPosition(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public OrderPosition(){}

    public void incrementQuantity(){
        this.quantity++;
    }

    public Product getProduct(){
        return product;
    }
    public int getQuantity(){
        return quantity;
    }

    public void setProduct(Product product){
        this.product = product;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
