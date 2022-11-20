package com.example.demo.repository;

 import com.example.demo.models.ServiceImages;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

 
public interface ServiceImagesRepo extends JpaRepository<ServiceImages, Long> {
    Optional<ServiceImages> findServiceImagesById(Long id);

 }
