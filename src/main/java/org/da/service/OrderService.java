package org.da.service;

import org.da.dto.Orders;

import java.util.List;

public interface OrderService {
    void addOrder(Orders orders);

    List<Orders> getall();

    Orders findById(String id);

    void removeOrder(String id);

    void updateOrder(Orders orders);
}
