package com.example.demo1.controllers;

import com.example.demo1.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {

    private final ProductService productService;

    public ShopController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/main")
    public String getMain(Model model){
        return "main";
    }

    @GetMapping("/basket")
    public String getBasket(Model model) {
        model.addAttribute("sum_price", this.productService.sumPrice());
        model.addAttribute("basket", this.productService.getBasketItems());
        return "basket";
    }

    @GetMapping("/products")
    public String getProduct(Model model) {
        model.addAttribute("getproducts", this.productService.getProducts());
        return "products";
    }

    @GetMapping("/basket/add/{productId}")
    public String addProduct(@PathVariable Long productId) {
        System.out.println(productId);
        productService.addProductToBasket(productId);
        return "redirect:/shop/products";
    }

    @RequestMapping(value = "/basket/sum")
    public String sumPrice(Model model){
        model.addAttribute("sum_price", this.productService.sumPrice());
        return "sum";
    }
}
