package com.example.demo.controllers;

import com.example.demo.Service.ReclamationService;
import com.example.demo.models.Reclamation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
    private final ReclamationService ReclamationService;

    public ReclamationController(ReclamationService ReclamationService) {
        this.ReclamationService = ReclamationService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Reclamation>> getAllReclamation(){
        //call the service that finds all tmm
        List<Reclamation> Reclamation=ReclamationService.findAllReclamation();
        return new ResponseEntity<>(Reclamation, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Reclamation> getReclamationById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        Reclamation Reclamation= ReclamationService.findReclamationById(id);
        return new ResponseEntity<>(Reclamation, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Reclamation> addReclamation(@RequestBody Reclamation Reclamation){
        Reclamation newReclamation = ReclamationService.addReclamation(Reclamation);
        return new ResponseEntity<>(newReclamation,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Reclamation> updateReclamation(@RequestBody Reclamation Reclamation, @PathVariable("id") Long id){
        Reclamation updateReclamation = ReclamationService.updateReclamation(Reclamation);
        return new ResponseEntity<>(updateReclamation,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteReclamation(@PathVariable("id") Long id){
        ReclamationService.deleteReclamation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
