package com.example.demo.controllers;

import com.example.demo.Service.ServicesService;
import com.example.demo.models.Services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {
    private final ServicesService ServicesService;

    public ServicesController(ServicesService ServicesService) {
        this.ServicesService = ServicesService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Services>> getAllServices(){
        //call the service that finds all tmm
        List<Services> Services=ServicesService.findAllService();
        return new ResponseEntity<>(Services, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Services> getServicesById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        Services Services= ServicesService.findServiceById(id);
        return new ResponseEntity<>(Services, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Services> addServices(@RequestBody Services Services){
        Services newServices = ServicesService.addService(Services);
        return new ResponseEntity<>(newServices,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Services> updateServices(@RequestBody Services Services, @PathVariable("id") Long id){
        Services updateServices = ServicesService.updateService(Services);
        return new ResponseEntity<>(updateServices,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteServices(@PathVariable("id") Long id){
        ServicesService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
