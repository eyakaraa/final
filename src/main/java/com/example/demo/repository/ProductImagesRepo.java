package com.example.demo.repository;

import com.example.demo.models.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

 
public interface ProductImagesRepo extends JpaRepository<ProductImages, Long> {
 }
