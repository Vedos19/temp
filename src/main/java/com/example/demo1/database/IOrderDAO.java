package com.example.demo1.database;

import com.example.demo1.model.Order;

import java.util.List;

public interface IOrderDAO {
    public void addOrder();

    public List<Order> getOrdersByUserId();
}
