package com.example.demo.controllers;

import com.example.demo.Service.ServiceImagesService;
import com.example.demo.models.ServiceImages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serviceImages")
public class ServicesImagesController {
    private final ServiceImagesService ServiceImagesService;

    public ServicesImagesController(ServiceImagesService ServiceImagesService) {
        this.ServiceImagesService = ServiceImagesService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<ServiceImages>> getAllServiceImages(){
        //call the service that finds all tmm
        List<ServiceImages> ServiceImages=ServiceImagesService.findAllServiceImages();
        return new ResponseEntity<>(ServiceImages, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<ServiceImages> getServiceImagesById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        ServiceImages ServiceImages= ServiceImagesService.findServiceImagesById(id);
        return new ResponseEntity<>(ServiceImages, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ServiceImages> addServiceImages(@RequestBody ServiceImages ServiceImages){
        ServiceImages newServiceImages = ServiceImagesService.addServiceImages(ServiceImages);
        return new ResponseEntity<>(newServiceImages,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceImages> updateServiceImages(@RequestBody ServiceImages ServiceImages, @PathVariable("id") Long id){
        ServiceImages updateServiceImages = ServiceImagesService.updateServiceImages(ServiceImages);
        return new ResponseEntity<>(updateServiceImages,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteServiceImages(@PathVariable("id") Long id){
        ServiceImagesService.deleteServiceImages(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
