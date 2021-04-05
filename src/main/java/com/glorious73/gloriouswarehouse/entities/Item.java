package com.glorious73.gloriouswarehouse.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    @Column(unique = true)
    private String serialNumber;
    private String name;
    private String base64Image;
    @ManyToOne @JoinColumn(name="supplier_id")
    @JsonBackReference
    private Supplier supplier;

    public Item() { }
    public Item(int quantity, String serialNumber, String name, String base64Image, Supplier supplier) {
        this.quantity = quantity;
        this.serialNumber = serialNumber;
        this.name = name;
        this.base64Image = base64Image;
        this.supplier = supplier;
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
                ", name='" + name + '\'' +
                '}';
    }
}
