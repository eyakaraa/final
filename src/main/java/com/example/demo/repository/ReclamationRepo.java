package com.example.demo.repository;

 import com.example.demo.models.Reclamation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

 
public interface ReclamationRepo extends JpaRepository<Reclamation, Long> {
    Optional<Reclamation> findReclamationById(Long id);

 }
