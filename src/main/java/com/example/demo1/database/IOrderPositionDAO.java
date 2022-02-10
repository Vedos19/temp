package com.example.demo1.database;

import com.example.demo1.model.OrderPosition;

public interface IOrderPositionDAO {
    void addOrderPosition(OrderPosition orderPosition, int order_id);
}
