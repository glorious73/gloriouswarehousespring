package com.glorious73.gloriouswarehouse.service;

import com.glorious73.gloriouswarehouse.entities.Supplier;
import com.glorious73.gloriouswarehouse.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Transactional
    public String createSupplier(Supplier supplier){
        try {
            if (!supplierRepository.existsBySocialSecurityNumber(supplier.getSocialSecurityNumber())){
                supplier.setId(null == supplierRepository.findMaxId()? 0 : supplierRepository.findMaxId() + 1);
                supplierRepository.save(supplier);
                return "Supplier record created successfully.";
            }else {
                return "Supplier already exists in the database.";
            }
        } catch (Exception e){
            throw e;
        }
    }

    public List<Supplier> readSuppliers(){
        return supplierRepository.findAll();
    }

    @Transactional
    public String updateSupplier(Supplier supplier, int id){
        if (supplierRepository.existsById(id)) {
            try {
                Supplier supplierToBeUpdated = supplierRepository.findById(id).get();
                supplierToBeUpdated.setFirstName(supplier.getFirstName());
                supplierToBeUpdated.setLastName(supplier.getLastName());
                supplierToBeUpdated.setSocialSecurityNumber(supplier.getSocialSecurityNumber());
                supplierRepository.save(supplierToBeUpdated);
                return "Supplier record updated.";
            } catch (Exception e){
                throw e;
            }
        } else
            return "Supplier does not exists in the database.";
    }

    @Transactional
    public String deleteSupplier(int id){
        if (supplierRepository.existsById(id)) {
            try {
                Supplier supplier = supplierRepository.findById(id).get();
                if(!supplier.getItems().isEmpty())
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot delete supplier if it has one or more items.");
                supplierRepository.delete(supplier);
                return "Supplier record deleted successfully.";
            } catch (Exception e){
                throw e;
            }

        } else {
            return "Supplier record does not exist.";
        }
    }
}
