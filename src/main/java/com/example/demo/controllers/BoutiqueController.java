package com.example.demo.controllers;

import com.example.demo.Service.BoutiqueService;
import com.example.demo.models.Boutique;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boutique")
public class BoutiqueController {
    private final BoutiqueService BoutiqueService;

    public BoutiqueController(BoutiqueService BoutiqueService) {
        this.BoutiqueService = BoutiqueService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Boutique>> getAllBoutique(){
        //call the service that finds all tmm
        List<Boutique> Boutique=BoutiqueService.findAllBoutique();
        return new ResponseEntity<>(Boutique, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Boutique> getBoutiqueById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        Boutique Boutique= BoutiqueService.findBoutiqueById(id);
        return new ResponseEntity<>(Boutique, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Boutique> addBoutique(@RequestBody Boutique Boutique){
        Boutique newBoutique = BoutiqueService.addBoutique(Boutique);
        return new ResponseEntity<>(newBoutique,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boutique> updateBoutique(@RequestBody Boutique Boutique, @PathVariable("id") Long id){
        Boutique updateBoutique = BoutiqueService.updateBoutique(Boutique);
        return new ResponseEntity<>(updateBoutique,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteBoutique(@PathVariable("id") Long id){
        BoutiqueService.deleteBoutique(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
