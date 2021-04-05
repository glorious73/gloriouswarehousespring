package com.glorious73.gloriouswarehouse.controller;

import com.glorious73.gloriouswarehouse.entities.Category;
import com.glorious73.gloriouswarehouse.service.CategoryService;
import com.glorious73.gloriouswarehouse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String createItem(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Category> readItems(){
        return categoryService.readCategories();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String updateItem(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleteItem(@RequestBody Category category){
        return categoryService.deleteCategory(category);
    }
}
