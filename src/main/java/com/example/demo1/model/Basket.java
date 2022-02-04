package com.example.demo1.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Product> basket_products = new ArrayList<>();

    private List<OrderPosition> orderPositions = new ArrayList<>();

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
            product2.addQuantity();
        }
    }

    public double sumPrice(){
        double sum = 0;

        for(int i = 0; i<basket_products.size(); i++){
            sum += basket_products.get(i).getQuantity() * basket_products.get(i).getPrice();
        }
        System.out.println("Do zapłaty: " + sum + "zł");
        return sum;
    }

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public double getSum() {
        double sum = 0.0;
        for(OrderPosition orderPosition : this.orderPositions) {
            sum += orderPosition.getQuantity() * orderPosition.getProduct().getPrice();
        }
        return Math.round(sum*100)/100.0;
    }

    public void clearOrderPositions() {
        this.orderPositions = new ArrayList<>();
    }
}
