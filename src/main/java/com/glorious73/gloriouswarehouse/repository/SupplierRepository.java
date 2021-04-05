package com.glorious73.gloriouswarehouse.repository;

import com.glorious73.gloriouswarehouse.entities.Item;
import com.glorious73.gloriouswarehouse.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    public boolean existsBySocialSecurityNumber(String socialSecurityNumber);

    public List<Supplier> findByFirstName(String firstName);
    public List<Supplier> findByLastName(String lastName);
    public List<Supplier> findBySocialSecurityNumber(String socialSecurityNumber);

    @Query("select max(i.id) from Item i")
    public Integer findMaxId();
}
