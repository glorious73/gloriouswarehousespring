package com.glorious73.gloriouswarehouse.service;

import com.glorious73.gloriouswarehouse.entities.Category;
import com.glorious73.gloriouswarehouse.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public String createCategory(Category category){
        try {
            if (!categoryRepository.existsByName(category.getName())){
                category.setId(null == categoryRepository.findMaxId()? 0 : categoryRepository.findMaxId() + 1);
                categoryRepository.save(category);
                return "Category record created successfully.";
            }else {
                return "Category already exists in the database.";
            }
        } catch (Exception e){
            throw e;
        }
    }

    public List<Category> readCategories() {
        return categoryRepository.findAll();
    }

    @Transactional
    public String updateCategory(Category category){
        if (categoryRepository.existsByName(category.getName())){
            try {
                List<Category> categories = categoryRepository.findByName(category.getName());
                categories.stream().forEach(i -> {
                    Category categoryToBeUpdated = categoryRepository.findById(i.getId()).get();
                    categoryToBeUpdated.setName(category.getName());
                    categoryToBeUpdated.setDescription(category.getDescription());
                    categoryRepository.save(categoryToBeUpdated);
                });
                return "Category record updated.";
            } catch (Exception e){
                throw e;
            }
        } else
            return "Category does not exists in the database.";
    }

    @Transactional
    public String deleteCategory(Category category){
        if (categoryRepository.existsByName(category.getName())){
            try {
                List<Category> categories = categoryRepository.findByName(category.getName());
                categories.stream().forEach(i -> {
                    categoryRepository.delete(i);
                });
                return "Category record deleted successfully.";
            } catch (Exception e){
                throw e;
            }
        } else {
            return "Category does not exist.";
        }
    }
}
