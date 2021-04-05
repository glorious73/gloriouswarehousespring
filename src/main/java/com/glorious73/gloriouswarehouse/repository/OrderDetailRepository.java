package com.glorious73.gloriouswarehouse.repository;

import com.glorious73.gloriouswarehouse.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    public boolean existsById(int id);

    @Query("select max(i.id) from Item i")
    public Integer findMaxId();
}
