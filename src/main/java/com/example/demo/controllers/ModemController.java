package com.example.demo.controllers;

import com.example.demo.security.services.ModemService;
import com.example.demo.models.Modem;
import com.example.demo.models.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/Modem")
public class ModemController {
    private final ModemService ModemService;

    public ModemController(ModemService ModemService) {
        this.ModemService = ModemService;
    }
    @GetMapping("/all/{from}/{to}/{username}")
    public ResponseEntity<List<Modem>> getAllModem(@PathVariable("from") String from,@PathVariable("to") String to, @PathVariable("username") String username) throws ParseException{
        //call the service that finds all tmm
        List<Modem> Modem=ModemService.findAllModem(from,to,username);
        return new ResponseEntity<>(Modem, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Modem> getModemById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        Modem Modem= ModemService.findModemById(id);
        return new ResponseEntity<>(Modem, HttpStatus.OK);
    }
    @GetMapping ("/dropdata")
    public ResponseEntity<?> drop(){
        ModemService.dropdata();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/dropdata")
    public ResponseEntity<?> vdropdata(@RequestBody List<Modem> Modems){
         ModemService.dropSelecteddata(Modems);
         return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/add/{username}")
    public ResponseEntity<Modem> addModem(@RequestBody Modem Modem,@PathVariable String username){
        Modem newModem = ModemService.addModem(Modem,username);
        return new ResponseEntity<>(newModem,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Modem> updateModem(@RequestBody Modem Modem, @PathVariable("id") Long id){
        Modem updateModem = ModemService.updateModem(Modem);
        return new ResponseEntity<>(updateModem,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteModem(@PathVariable("id") Long id){
        ModemService.deleteModem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
