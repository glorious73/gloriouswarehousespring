package com.glorious73.gloriouswarehouse.repository;

import com.glorious73.gloriouswarehouse.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    public boolean existsBySerialNumber(String serialNumber);

    public List<Item> findByName(String name);
    public List<Item> findBySerialNumber(String serialNumber);

    @Query("select max(i.id) from Item i")
    public Integer findMaxId();
}
