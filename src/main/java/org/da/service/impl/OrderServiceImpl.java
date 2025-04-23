package org.da.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.da.dto.Orders;
import org.da.entity.OrderEntity;
import org.da.repository.OrderRepository;
import org.da.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    @Override
    public void addOrder(Orders orders) {
        OrderEntity OrderEntity
                = new ObjectMapper().convertValue(orders, OrderEntity.class);
        OrderEntity savedOrder = repository.save(OrderEntity);
    }

    @Override
    public List<Orders> getall() {
        Iterable<OrderEntity> allOrders = repository.findAll();
        List<Orders> orderList=new ArrayList<>();

        allOrders.forEach(orderEntity -> {
            orderList.add(new ObjectMapper().convertValue(orderEntity, Orders.class));
        });

        return orderList;
    }

    @Override
    public Orders findById(String id) {
        if(repository.findByOrderid(id).isPresent()){
            Optional<OrderEntity> byId = repository.findById(id);
            return new ObjectMapper().convertValue(byId.get(), Orders.class);
        }
        return new Orders();
    }

    @Override
    public void removeOrder(String id) {

        if (repository.existsById(id))
        {
            repository.deleteById(id);
        }

    }

    @Override
    public void updateOrder(Orders orders) {
        if(repository.findById(orders.getOrderid()).isPresent()){
            repository.save(new ObjectMapper().convertValue(orders, OrderEntity.class));
        }
    }
}
