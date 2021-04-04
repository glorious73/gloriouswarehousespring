package com.glorious73.gloriouswarehouse.entities;

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
    @ManyToOne @JoinColumn(name="item_id")
    private Supplier supplier;

    public Item() {

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
