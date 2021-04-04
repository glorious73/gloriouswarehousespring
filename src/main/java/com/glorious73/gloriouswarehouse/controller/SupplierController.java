package com.glorious73.gloriouswarehouse.controller;

import com.glorious73.gloriouswarehouse.entities.Supplier;
import com.glorious73.gloriouswarehouse.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createItem(@RequestBody Supplier supplier){
        return supplierService.createSupplier(supplier);
    }

    @RequestMapping(value = "read", method = RequestMethod.GET)
    public List<Supplier> readItems(){
        return supplierService.readSuppliers();
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public String updateItem(@RequestBody Supplier supplier){
        return supplierService.updateSupplier(supplier);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String deleteItem(@RequestBody Supplier supplier){
        return supplierService.deleteSupplier(supplier);
    }
}
