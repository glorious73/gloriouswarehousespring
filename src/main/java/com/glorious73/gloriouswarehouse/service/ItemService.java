package com.glorious73.gloriouswarehouse.service;

import com.glorious73.gloriouswarehouse.entities.Item;
import com.glorious73.gloriouswarehouse.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public String createItem(Item item){
        try {
            if (!itemRepository.existsBySerialNumber(item.getSerialNumber())){
                item.setId(null == itemRepository.findMaxId()? 0 : itemRepository.findMaxId() + 1);
                itemRepository.save(item);
                return "Item record created successfully.";
            }else {
                return "Item already exists in the database.";
            }
        } catch (Exception e){
            throw e;
        }
    }

    public List<Item> readItems(){
        return itemRepository.findAll();
    }

    @Transactional
    public String updateItem(Item item){
        if (itemRepository.existsBySerialNumber(item.getSerialNumber())){
            try {
                List<Item> items = itemRepository.findBySerialNumber(item.getSerialNumber());
                items.stream().forEach(i -> {
                    Item itemToBeUpdated = itemRepository.findById(i.getId()).get();
                    itemToBeUpdated.setName(item.getName());
                    itemToBeUpdated.setSerialNumber(item.getSerialNumber());
                    itemRepository.save(itemToBeUpdated);
                });
                return "Item record updated.";
            } catch (Exception e){
                throw e;
            }
        } else
            return "Item does not exists in the database.";
    }

    @Transactional
    public String deleteItem(Item item){
        if (itemRepository.existsBySerialNumber(item.getSerialNumber())){
            try {
                List<Item> items = itemRepository.findBySerialNumber(item.getSerialNumber());
                items.stream().forEach(i -> {
                    itemRepository.delete(i);
                });
                return "Item record deleted successfully.";
            } catch (Exception e){
                throw e;
            }

        } else {
            return "Item does not exist.";
        }
    }
}
