package com.example.demo.controllers;

import com.example.demo.Service.ProductImagesService;
import com.example.demo.models.ProductImages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productImages")
public class ProductImagesController {
    private final ProductImagesService ProductImagesService;

    public ProductImagesController(ProductImagesService ProductImagesService) {
        this.ProductImagesService = ProductImagesService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<ProductImages>> getAllProductImages(){
        //call the service that finds all tmm
        List<ProductImages> ProductImages=ProductImagesService.findAllProductImages();
        return new ResponseEntity<>(ProductImages, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<ProductImages> getProductImagesById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        ProductImages ProductImages= ProductImagesService.findProductImagesById(id);
        return new ResponseEntity<>(ProductImages, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ProductImages> addProductImages(@RequestBody ProductImages ProductImages){
        ProductImages newProductImages = ProductImagesService.addProductImages(ProductImages);
        return new ResponseEntity<>(newProductImages,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductImages> updateProductImages(@RequestBody ProductImages ProductImages, @PathVariable("id") Long id){
        ProductImages updateProductImages = ProductImagesService.updateProductImages(ProductImages);
        return new ResponseEntity<>(updateProductImages,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteProductImages(@PathVariable("id") Long id){
        ProductImagesService.deleteProductImages(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
