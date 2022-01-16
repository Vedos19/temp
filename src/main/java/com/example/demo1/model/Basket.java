package com.example.demo1.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Product> basket_products = new ArrayList<>();

    public List<Product> getBasketProducts() {
        return basket_products;
    }

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
            //utworzenie drugiego obiektu - problem z referencjami
            Product product2 = basket_products.stream()
                    .filter(product1 -> product1.getName()
                            .equals(product.getName()))
                    .findFirst()
                    .get();
            product2.addAmount();
        }
    }

    public double sumPrice(){
        double sum = 0;

        for(int i = 0; i<basket_products.size(); i++){
            sum += basket_products.get(i).getAmount() * basket_products.get(i).getPrice();
        }
        System.out.println("Do zapłaty: " + sum + "zł");
        return sum;
    }
}
