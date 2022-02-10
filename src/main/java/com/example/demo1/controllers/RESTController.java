package com.example.demo1.controllers;

import com.example.demo1.interfaces.IProductRepository;
import com.example.demo1.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RESTController {

    private final IProductRepository iproductRepository;

    public RESTController(IProductRepository iproductRepository) {
        this.iproductRepository = iproductRepository;
    }

    @GetMapping("/byid/{id}")
    public List<Product> filterById(@PathVariable Long id) {
        return iproductRepository.filterProductsById(id);
    }

    @GetMapping("/bytype/{type}")
    public List<Product> filterByType(@PathVariable String type) {
        return iproductRepository.filterProductsByType(type);
    }
}
