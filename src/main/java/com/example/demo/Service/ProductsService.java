package com.example.demo.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Products;
import com.example.demo.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductsService {
    private final ProductsRepo productsRepo;
    @Autowired
    public ProductsService(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    public Products addProduct(Products products){
        return productsRepo.save(products);
    }
    public List<Products> findAllProducts(){
        return productsRepo.findAll();
    }
    public Products updateProduct(Products products){
        return productsRepo.save(products);
    }
    public Products findProductById(Long id){
        return productsRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));
    }
    public void deleteProduct(Long id){
        productsRepo.deleteById(id);    }
}
