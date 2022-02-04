package com.example.demo1.interfaces;

import com.example.demo1.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();
    List<Product> getBasketItems();
    void addProductToBasket(Long productId);
    double sumPrice();
}
