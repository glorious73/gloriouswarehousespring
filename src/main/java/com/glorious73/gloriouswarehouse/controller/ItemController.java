package com.glorious73.gloriouswarehouse.controller;

import com.glorious73.gloriouswarehouse.entities.Item;
import com.glorious73.gloriouswarehouse.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Item> readItems(){
        return itemService.readItems();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String updateItem(@RequestBody Item item){
        return itemService.updateItem(item);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleteItem(@RequestBody Item item){
        return itemService.deleteItem(item);
    }
}
