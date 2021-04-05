package com.glorious73.gloriouswarehouse.controller;

import com.glorious73.gloriouswarehouse.entities.Supplier;
import com.glorious73.gloriouswarehouse.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String createSupplier(@RequestBody Supplier supplier){
        return supplierService.createSupplier(supplier);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Supplier> readSupplier(){
        return supplierService.readSuppliers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateSupplier(@RequestBody Supplier supplier, @PathVariable int id){
        return supplierService.updateSupplier(supplier, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteSupplier(@PathVariable int id){
        return supplierService.deleteSupplier(id);
    }
}
