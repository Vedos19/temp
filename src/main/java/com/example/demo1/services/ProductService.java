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

        if(product.getQuantity() > 0){
            Product product1 = new Product();
                product1.setId(product.getId());
                product1.setName(product.getName());
                product1.setType(product.getType());
                product1.setPrice(product.getPrice());
                product1.setQuantity(1);
            basket.addProduct(product1);
            product.setQuantity(product.getQuantity() - 1);
            productRepository.save(product);
        }
    }

    public double sumPrice(){
        return basket.sumPrice();
    }
}
