package com.glorious73.gloriouswarehouse.service;

import com.glorious73.gloriouswarehouse.dto.ItemDTO;
import com.glorious73.gloriouswarehouse.dto.OrderDTO;
import com.glorious73.gloriouswarehouse.entities.Category;
import com.glorious73.gloriouswarehouse.entities.Item;
import com.glorious73.gloriouswarehouse.entities.Order;
import com.glorious73.gloriouswarehouse.entities.OrderDetail;
import com.glorious73.gloriouswarehouse.repository.ItemRepository;
import com.glorious73.gloriouswarehouse.repository.OrderRepository;
import com.glorious73.gloriouswarehouse.repository.SupplierRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public String createOrder(OrderDTO orderDTO){
        try {
            // 1. Validate items and quantities
            boolean validOrder = validateOrderItems(orderDTO);
            // 2. Create OrderDetail for each item (order detail list)
            List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
            for (ItemDTO itemDTO: orderDTO.items) {
                // 2.1 Create object
                OrderDetail orderDetail = new OrderDetail();
                // 2.2 Add item to order detail
                Item item = itemRepository.findById(itemDTO.itemId).get();
                orderDetail.setItem(item);
                // 2.3 Calculate total price
                orderDetail.setItemQuantity(itemDTO.quantity);
                orderDetail.setTotalPrice(itemDTO.quantity*item.getUnitPrice());
                // 2.4 Add to order detail list
                orderDetailList.add(orderDetail);
            }
            // 3. Create Order
            Order order = new Order();
            // 4. Add all order details to order
            order.setOrderDetails(orderDetailList);
            // 5. Save order and return
            Order savedOrder = orderRepository.save(order);
            return "Order " + savedOrder.getId() + " created successfully.";
        } catch (Exception e){
            throw e;
        }
    }

    public List<Order> readOrders() {
        return orderRepository.findAll();
    }

    // No Edit and Delete methods to maintain the integrity of the system.

    private boolean validateOrderItems(OrderDTO orderDTO) {
        try {
            for (ItemDTO itemDTO: orderDTO.items) {
                // 1. Validate positive quantity
                if(itemDTO.quantity <= 0)
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The quantity of each item must be positive.");
                // 2. find item related to DTO
                if(!itemRepository.existsById(itemDTO.itemId))
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item record with Id " + itemDTO.itemId + " does not exist.");
                Item item = itemRepository.findById(itemDTO.itemId).get();
                // 3. validate that there is enough quantity
                if(item.getQuantity() < itemDTO.quantity)
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is not enough quantity for the item \"" + item.getName() + "\"");
            }
            return true;
        }
        catch(Exception ex) {
            throw ex;
        }
    }
}
