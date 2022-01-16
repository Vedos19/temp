package com.example.demo1.model;

import com.example.demo1.database.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    DB db;

    public List<Product> getProducts(){
        return db.getProducts();
    }

    public List<Product> getBasketItems(){
        return db.getBasket().getBasketProducts();
    }

    public void addProductToBasket(int productId) {
        db.addProductToBasket(productId);
    }

    public double sumPrice(){
        return db.getBasket().sumPrice();
    }
}
