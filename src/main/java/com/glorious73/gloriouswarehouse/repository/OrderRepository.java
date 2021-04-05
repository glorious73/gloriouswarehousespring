package com.glorious73.gloriouswarehouse.repository;

import com.glorious73.gloriouswarehouse.entities.Category;
import com.glorious73.gloriouswarehouse.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    public boolean existsById(int id);

    @Query("select max(i.id) from Item i")
    public Integer findMaxId();
}
