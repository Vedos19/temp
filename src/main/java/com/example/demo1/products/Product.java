package com.example.demo1.products;

public class Product {
    private String name, type;
    private double price;
    private int id, amount;

    public Product(int id, int amount, double price, String name, String type) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "id - " + id + " | nazwa - " + name +
                " | " + price + "zł | ilość - " + amount + '}';
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
    public int getId() {
        return id;
    }
    public int getAmount() {
        return amount;
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
    public void setId(int id) {
        this.id = id;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
}