package com.example.demo1.database;

import com.example.demo1.interfaces.IProductRepository;
import com.example.demo1.model.Basket;
import com.example.demo1.model.Order;
import com.example.demo1.model.Product;
import com.example.demo1.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DB {

    private final List<Product> products = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();
    private final IProductRepository productRepository;


    public DB(IProductRepository productRepository) {
        this.productRepository = productRepository;
        products.add(new Product("Żółw żółtolicy","zwierzę",20,70));
        products.add(new Product("Żółw grecki","zwierzę",20,120));
        products.add(new Product("Bojownik","zwierzę",20,30));
        products.add(new Product("Karma dla żółwi","karma",20,10));
        products.add(new Product("Karma dla rybek","karma",20,10));
        products.add(new Product("Karma dla kotów","karma",20,10));

        users.add(new User(1L, "Wiktor", "Pompka", "admin", "admin"));
    }

    public Optional<User> getUserByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long productId) {
        for(Product product : this.products) {
            if(product.getId() == productId) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getOrdersByUserId(int userId) {
        List<Order> result = new ArrayList<>();
        for(Order order : this.orders) {
            if(order.getUser().getId().equals(userId)) {
                result.add(order);
            }
        }
        return result;
    }

    public void addUser(User user) {
        this.users.add(user);
    }
}
