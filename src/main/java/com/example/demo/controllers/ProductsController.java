package com.example.demo.controllers;

import com.example.demo.models.Products;
import com.example.demo.security.services.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Products>> getAllProducts(){
        //call the service that finds all tmm
        List<Products> products=productsService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        Products product= productsService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Products> addProduct(@RequestBody Products products){
        Products newProduct = productsService.addProduct(products);
        return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Products> updateProduct(@RequestBody Products products, @PathVariable("id") Long id){
        Products updateProducts = productsService.updateProduct(products);
        return new ResponseEntity<>(updateProducts,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id){
        productsService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
