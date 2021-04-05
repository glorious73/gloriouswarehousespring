package com.glorious73.gloriouswarehouse.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

// Many To Many relationship table
@Entity
@Table(name="OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne @JoinColumn(name="order_id")
    @JsonBackReference(value="order")
    private Order order;
    @ManyToOne @JoinColumn(name="item_id", referencedColumnName = "id")
    @JsonIgnore
    private Item item;
    // Relationship fields
    private int itemQuantity;
    private double totalPrice;

    public OrderDetail() { }

    public OrderDetail(Order order, Item item, int itemQuantity, double totalPrice) {
        this.order        = order;
        this.item         = item;
        this.itemQuantity = itemQuantity;
        this.totalPrice   = totalPrice;
    }

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
