package com.example.demo.repository;

import com.example.demo.models.Services;
 
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicesRepo extends JpaRepository<Services, Long> {
    Optional<Services> findServiceById(Long id);

 }
