package com.example.demo1.database;

import com.example.demo1.model.Basket;
import com.example.demo1.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DB {

    private final List<Product> products = new ArrayList<>();

    private Basket basket = new Basket();

    public DB() {
        products.add(new Product(1,20,70,"Żółw żółtolicy","zwierzę"));
        products.add(new Product(2,20,120,"Żółw grecki","zwierzę"));
        products.add(new Product(3,20,30,"Bojownik","zwierzę"));
        products.add(new Product(4,20,10,"Karma dla żółwi","karma"));
        products.add(new Product(5,20,10,"Karma dla rybek","karma"));
        products.add(new Product(6,20,10,"Karma dla kotów","karma"));
    }

    public Basket getBasket() {
        return basket;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        for(Product product : this.products) {
            if(product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void addProductToBasket(int productId) {
        Product product = getProductById(productId);
        System.out.println(product);

        basket.addProduct(product);
        product.setAmount(product.getAmount() - 1);
    }
}
