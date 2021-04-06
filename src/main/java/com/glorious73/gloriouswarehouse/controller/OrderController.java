package com.glorious73.gloriouswarehouse.controller;

import com.glorious73.gloriouswarehouse.dto.OrderDTO;
import com.glorious73.gloriouswarehouse.entities.Category;
import com.glorious73.gloriouswarehouse.entities.Order;
import com.glorious73.gloriouswarehouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Order readOrder(@PathVariable int id){
        return orderService.readById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Order> readOrders(){
        return orderService.readOrders();
    }
}
