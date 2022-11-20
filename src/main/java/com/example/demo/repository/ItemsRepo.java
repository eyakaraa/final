package com.example.demo.repository;

import com.example.demo.models.Commande;
import com.example.demo.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemsRepo extends JpaRepository<Items, Long> {
    Optional<Items> findItemsById(Long id);

 }
