package com.glorious73.gloriouswarehouse.controller;

import com.glorious73.gloriouswarehouse.entities.Category;
import com.glorious73.gloriouswarehouse.service.CategoryService;
import com.glorious73.gloriouswarehouse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category readCategory(@PathVariable int id){
        return categoryService.readById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Category> readCategories(){
        return categoryService.readCategories();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateItem(@RequestBody Category category, @PathVariable int id){
        return categoryService.updateCategory(category, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteItem(@PathVariable int id){
        return categoryService.deleteCategory(id);
    }
}
