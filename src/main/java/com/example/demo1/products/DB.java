package com.example.demo1.products;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DB {

    public DB() {
        products.add(new Product(1,3,70,"Żółw żółtolicy","zwierzę"));
        products.add(new Product(2,2,120,"Żółw grecki","zwierzę"));
        products.add(new Product(3,5,30,"Bojownik","zwierzę"));
        products.add(new Product(4,20,10,"Karma dla żółwi","karma"));
        products.add(new Product(5,20,10,"Karma dla rybek","karma"));
        products.add(new Product(6,20,10,"Karma dla kotów","karma"));
    }

    public List<Product> getProducts() {
        return products;
    }

    private final List<Product> products = new ArrayList<>();
}
