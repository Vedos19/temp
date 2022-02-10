package com.example.demo1.database.impl.jbdc;

import com.example.demo1.database.IProductDAO;
import com.example.demo1.model.Product;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements IProductDAO {
    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Optional<Product> getProductById() {
        return Optional.empty();
    }
}