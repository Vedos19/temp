package com.example.demo1.database;

import com.example.demo1.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductDAO {
    public List<Product> getProducts();

    public Optional<Product> getProductById();
}
