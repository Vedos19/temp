package com.example.demo1.controllers;

import com.example.demo1.model.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {
    private final ProductService productService;

    @Autowired
    public ShopController(ProductService productService) { this.productService = productService; }

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cart_products", this.productService.getBasketItems());
        return "cart_products";
    }

    @RequestMapping(value = "/cart/add/{productId}")
    public String addProduct(@PathVariable Integer productId) {
        productService.addProductToCart(productId);
        return "main";
    }

    @GetMapping("/product-list")
    public String getProduct(Model model) {
        //wypisanie produktow w stringu na stronie
        model.addAttribute("products", this.productService.getProducts());
        return "products";
    }
}
