package com.suprapartimport.system.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// API Layer
// We are creating a separate API resource class called as Controller, which talks to Service
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/item")
public class ItemController {

    private final ItemService itemService;

    // Dependency injection via Autowired annotation.
    // With @Autowired we tell that Item service (or anything we pass into the constructor) should be Autowired for us
    // "itemService" will be instantiated and injected into ItemController(ItemService itemService) constructor
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Get class, which uses itemService in return
    @GetMapping
    public List<Item> getAllItems()
    {
        return itemService.getAllItems();
    }

    // POST implementation
    // We take RequestBody and map it to Item
    @PostMapping
    public void registerNewItem(@RequestBody Item item) {
        itemService.addNewItem(item);
    }

    @DeleteMapping(path = "{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(
            @PathVariable("itemId") Long itemId,
            @RequestParam(required = false) String name, String description) {
        itemService.updateItem(itemId, name, description);
    }

}
