package com.example.demo.controllers;

import com.example.demo.Service.CommandeService;
import com.example.demo.models.Commande;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    private final CommandeService CommandeService;

    public CommandeController(CommandeService CommandeService) {
        this.CommandeService = CommandeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Commande>> getAllCommande(){
        //call the service that finds all tmm
        List<Commande> Commande=CommandeService.findAllCommande();
        return new ResponseEntity<>(Commande, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        Commande Commande= CommandeService.findCommandeById(id);
        return new ResponseEntity<>(Commande, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Commande> addCommande(@RequestBody Commande Commande){
        Commande newCommande = CommandeService.addCommande(Commande);
        return new ResponseEntity<>(newCommande,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Commande> updateCommande(@RequestBody Commande Commande, @PathVariable("id") Long id){
        Commande updateCommande = CommandeService.updateCommande(Commande);
        return new ResponseEntity<>(updateCommande,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteCommande(@PathVariable("id") Long id){
        CommandeService.deleteCommande(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
