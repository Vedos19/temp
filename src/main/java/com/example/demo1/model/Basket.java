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
        for(Product product : basket_products){
            if(product.getName().equals(productName)){
                return true;
            }
        }
        return false;
    }

    public void addProduct(Product product){
        if(!checkIfProductIsOnListByName(product.getName())) {
            this.basket_products.add(product);
        }
        else{
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
