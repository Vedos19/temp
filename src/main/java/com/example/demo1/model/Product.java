package com.example.demo1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;
    private double price;
    private String name;
    private String type;

    public Product(String name, String type, double price, int quantity) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(){}

    //kopia do koszyka
    public Product(Product product){
        this.id = product.id;
        this.quantity = 1;
        this.price = product.price;
        this.name = product.name;
        this.type = product.type;
    }

    @Override
    public String toString() {
        return "id - " + id + " | nazwa - " + name +
                " | " + price + "zł | ilość - " + quantity + '}';
    }

    public void addQuantity(){
        this.quantity++;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
    public Long getId() {
        return id;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}