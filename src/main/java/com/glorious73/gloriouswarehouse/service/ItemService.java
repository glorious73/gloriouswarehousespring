package com.glorious73.gloriouswarehouse.service;

import com.glorious73.gloriouswarehouse.entities.Category;
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

    public Item readById(int id) {
        return itemRepository.findById(id).get();
    }

    public List<Item> readItems(){
        return itemRepository.findAll();
    }

    @Transactional
    public String updateItem(Item item, int id){
        if (itemRepository.existsById(id)){
            try {
                Item itemToBeUpdated = itemRepository.findById(id).get();
                itemToBeUpdated.setName(item.getName());
                itemToBeUpdated.setSerialNumber(item.getSerialNumber());
                itemToBeUpdated.setQuantity(item.getQuantity());
                itemToBeUpdated.setBase64Image(item.getBase64Image());
                itemRepository.save(itemToBeUpdated);
                return "Item record updated.";
            } catch (Exception e){
                throw e;
            }
        } else
            return "Item does not exist in the database.";
    }

    @Transactional
    public String updateItemQuantity(int id, int quantity) {
        try {
            if (itemRepository.existsById(id)){ 
                if(quantity > 0) {
                    Item itemToBeUpdated = itemRepository.findById(id).get();
                    itemToBeUpdated.setQuantity(quantity);
                    itemRepository.save(itemToBeUpdated);
                    return "Item quantity updated by " + quantity + ".";
                }
                else
                    return "New quantity must be positive.";
            }
            else 
                return "Item does not exist in the database";
        }
        catch(Exception ex) {
            throw ex;
        }
    }

    @Transactional
    public String deleteItem(int id){
        if (itemRepository.existsById(id)){
            try {
                Item item = itemRepository.findById(id).get();
                itemRepository.delete(item);
                return "Item record deleted successfully.";
            } catch (Exception e){
                throw e;
            }

        } else {
            return "Item does not exist.";
        }
    }
}
