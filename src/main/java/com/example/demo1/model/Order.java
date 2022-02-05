package com.example.demo1.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private double price;
    @OneToMany
    private Set<OrderPosition> orderPositions = new HashSet<>();
    private LocalDateTime date;

    public Order(Long id, User user, double price, Set<OrderPosition> orderPositions, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.price = price;
        //this.orderPositions = orderPositions;
        this.date = date;
    }

    public Order(User user, Set<OrderPosition> orderPositions) {
        this.user = user;
        date = LocalDateTime.now();
        this.price = 0;
        for(OrderPosition orderPosition : orderPositions) {
            this.price += orderPosition.getProduct().getPrice() * orderPosition.getQuantity();
        }
        this.price = Math.round(this.price*100)/100.0;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public double getPrice() {
        return price;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
