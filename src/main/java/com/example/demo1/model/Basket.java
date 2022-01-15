package com.example.demo1.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Product> basket_products = new ArrayList<>();

    public Basket() {
    }

    private boolean checkIfProductIsOnListByName(String productName){
        return basket_products.stream()
                .anyMatch(product -> product
                        .getName()
                        .equals(productName));
    }

    public void addProduct(Product product){
        if(!checkIfProductIsOnListByName(product.getName())) {
            Product product1 = new Product(product);
            this.basket_products.add(product1);
        }
        else{
            Product product2 = basket_products.stream()
                    .filter(product1 -> product1.getName()
                            .equals(product.getName()))
                    .findFirst()
                    .get();
            product2.addAmount();
        }
    }
    public List<Product> getBasketProducts() {
        return basket_products;
    }
}
