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
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @RequestMapping(value = "read", method = RequestMethod.GET)
    public List<Item> readItems(){
        return itemService.readItems();
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public String updateItem(@RequestBody Item item){
        return itemService.updateItem(item);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String deleteItem(@RequestBody Item item){
        return itemService.deleteItem(item);
    }
}
