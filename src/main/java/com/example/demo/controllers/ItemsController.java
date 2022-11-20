package com.example.demo.controllers;

import com.example.demo.Service.ItemsService;
import com.example.demo.models.Items;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {
    private final ItemsService ItemsService;

    public ItemsController(ItemsService ItemsService) {
        this.ItemsService = ItemsService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Items>> getAllItems(){
        //call the service that finds all tmm
        List<Items> Items=ItemsService.findAllItems();
        return new ResponseEntity<>(Items, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Items> getItemsById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        Items Items= ItemsService.findItemsById(id);
        return new ResponseEntity<>(Items, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Items> addItems(@RequestBody Items Items){
        Items newItems = ItemsService.addItems(Items);
        return new ResponseEntity<>(newItems,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Items> updateItems(@RequestBody Items Items, @PathVariable("id") Long id){
        Items updateItems = ItemsService.updateItems(Items);
        return new ResponseEntity<>(updateItems,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteItems(@PathVariable("id") Long id){
        ItemsService.deleteItems(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
