package com.example.demo1.services;

import com.example.demo1.interfaces.IProductRepository;
import com.example.demo1.interfaces.IProductService;
import com.example.demo1.database.DB;
import com.example.demo1.model.Basket;
import com.example.demo1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    Basket basket = new Basket();

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public List<Product> getBasketItems(){
        return basket.getBasketProducts();
    }

    public void addProductToBasket(Long productId) {
        Product product = productRepository.getById(productId);
        //del
        System.out.println(product);
        basket.addProduct(product);
        product.setQuantity(product.getQuantity() - 1);
    }

    public double sumPrice(){
        return basket.sumPrice();
    }
}
