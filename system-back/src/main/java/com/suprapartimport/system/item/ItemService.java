package com.suprapartimport.system.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Business Logic / Service Layer
// Logic for managing Items
// In order for API to get the data, it should talk to Service and Service to Data Layer

// This annotation is meant for a better readability
// We are telling that this class is a Spring Bean, which can be instantiated (in Controller class)
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems()
    {
        return itemRepository.findAll();
    }

    // For POST method
    public void addNewItem(Item item) {
        // Custom logic if I want the names to be unique
        /*Optional<Item> itemOptional = itemRepository
                .findItemByName(item.getName());
        if (itemOptional.isPresent()) {
            throw new IllegalStateException("Name is taken");
        }*/
        itemRepository.save(item);
        System.out.println(item);
    }

    public void deleteItem(Long itemId) {
        boolean exists = itemRepository.existsById(itemId);
        if (!exists) {
            throw new IllegalStateException("Item with id " + itemId + " does not exist");
        }
        itemRepository.deleteById(itemId);
    }

    @Transactional
    public void updateItem(Long itemId,
                           String name,
                           String description) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalStateException(
                        "Item with id" + itemId + " does not exist"
                ));

        if (name != null &&
            name.length() > 0 &&
            !Objects.equals(item.getName(), name)) {
            item.setName(name);
            item.setDescription(description);
        }

    }
}
