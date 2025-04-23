package org.da.controller;

import lombok.RequiredArgsConstructor;
import org.da.dto.Orders;
import org.da.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order-controller")
@RequiredArgsConstructor
public class OrderController {
    final OrderService service;
    @PostMapping("/add-order")
    public void add(@RequestBody Orders orders){
        service.addOrder(orders);
    }
    @GetMapping("/get-all")
    public List<Orders> getall(){
        return service.getall();
    }
    @GetMapping("/find-by-id/{id}")
    public Orders findById(@PathVariable String id){

        return service.findById(id);
    }
    @DeleteMapping("/delete-order/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployee(@PathVariable String id) {
        service.removeOrder(id);
        return "Deleted";

    }

    @PutMapping("/update-Order")
    public void updateEmployee(@RequestBody Orders orders){
        service.updateOrder(orders);

    }

}
