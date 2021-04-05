package com.glorious73.gloriouswarehouse.repository;

import com.glorious73.gloriouswarehouse.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public boolean existsById(int id);
    public boolean existsByName(String name);

    public List<Category> findByName(String name);

    @Query("select max(i.id) from Item i")
    public Integer findMaxId();
}
