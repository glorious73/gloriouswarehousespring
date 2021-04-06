package com.glorious73.gloriouswarehouse.controller;

import com.glorious73.gloriouswarehouse.entities.Category;
import com.glorious73.gloriouswarehouse.entities.Item;
import com.glorious73.gloriouswarehouse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Item readItem(@PathVariable int id){
        return itemService.readById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Item> readItems(){
        return itemService.readItems();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateItem(@RequestBody Item item, @PathVariable int id){ return itemService.updateItem(item, id); }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteItem(@PathVariable int id){
        return itemService.deleteItem(id);
    }
}
