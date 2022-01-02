package com.example.demo1.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping(path = "shop/product-list")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) { this.productService = productService; }

    @GetMapping
    public String getProduct(Model model) {
        //wypisanie produktow w stringu na stronie
        model.addAttribute("products", this.productService.getProducts());
        return "products";
    }
}