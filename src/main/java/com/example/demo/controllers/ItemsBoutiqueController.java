package com.example.demo.controllers;

import com.example.demo.Service.ItemsBoutiqueService;
import com.example.demo.models.ItemsBoutique;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemsBoutique")
public class ItemsBoutiqueController {
    private final ItemsBoutiqueService ItemsBoutiqueService;

    public ItemsBoutiqueController(ItemsBoutiqueService ItemsBoutiqueService) {
        this.ItemsBoutiqueService = ItemsBoutiqueService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<ItemsBoutique>> getAllItemsBoutique(){
        //call the service that finds all tmm
        List<ItemsBoutique> ItemsBoutique=ItemsBoutiqueService.findAllItemsBoutique();
        return new ResponseEntity<>(ItemsBoutique, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<ItemsBoutique> getItemsBoutiqueById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        ItemsBoutique ItemsBoutique= ItemsBoutiqueService.findItemsBoutiqueById(id);
        return new ResponseEntity<>(ItemsBoutique, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ItemsBoutique> addItemsBoutique(@RequestBody ItemsBoutique ItemsBoutique){
        ItemsBoutique newItemsBoutique = ItemsBoutiqueService.addItemsBoutique(ItemsBoutique);
        return new ResponseEntity<>(newItemsBoutique,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ItemsBoutique> updateItemsBoutique(@RequestBody ItemsBoutique ItemsBoutique, @PathVariable("id") Long id){
        ItemsBoutique updateItemsBoutique = ItemsBoutiqueService.updateItemsBoutique(ItemsBoutique);
        return new ResponseEntity<>(updateItemsBoutique,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteItemsBoutique(@PathVariable("id") Long id){
        ItemsBoutiqueService.deleteItemsBoutique(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
