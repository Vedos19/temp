package com.example.demo1.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    DB db;

    public List<Product> getProducts() {
        return db.getProducts();
    }
}
