package com.glorious73.gloriouswarehouse.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

// Many To Many relationship table
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="order_id")
    @JsonBackReference(value="order")
    private Order order;
    @ManyToOne
    @JoinColumn(name="item_id")
    @JsonBackReference(value="item")
    private Item item;
    private int itemQuantity;
    private double totalPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", order=" + order +
                ", item=" + item +
                ", itemQuantity=" + itemQuantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
