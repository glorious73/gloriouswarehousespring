package com.glorious73.gloriouswarehouse.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private double unitPrice;
    @Column(unique = true)
    private String serialNumber;
    private String name;
    private String base64Image;
    @ManyToOne @JoinColumn(name="supplier_id")
    @JsonBackReference(value="supplier")
    private Supplier supplier;
    @ManyToOne @JoinColumn(name="category_id")
    @JsonBackReference(value="category")
    private Category category;
    @OneToMany(cascade= CascadeType.ALL, mappedBy="item",targetEntity=OrderDetail.class)
    @JsonIgnore
    private Collection<OrderDetail> orderDetails;

    public Item() { }
    public Item(int quantity, double unitPrice, String serialNumber, String name, String base64Image, Supplier supplier, Category category) {
        this.quantity     = quantity;
        this.unitPrice    = unitPrice;
        this.serialNumber = serialNumber;
        this.name         = name;
        this.base64Image  = base64Image;
        this.supplier     = supplier;
        this.category     = category;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Category getCategory() { return category; }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setCategory(Category category) { this.category = category; }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", serialNumber='" + serialNumber + '\'' +
                ", name='" + name + '\'' +
                ", base64Image='" + base64Image + '\'' +
                ", supplier=" + supplier +
                ", category=" + category +
                '}';
    }
}
