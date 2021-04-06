package com.glorious73.gloriouswarehouse.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name="ApplicationOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateTime;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    @OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL, mappedBy="order",targetEntity=OrderDetail.class)
    @JsonManagedReference(value="order")
    private Collection<OrderDetail> orderDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Collection<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Collection<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
