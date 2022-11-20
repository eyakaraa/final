package com.example.demo.repository;

import com.example.demo.models.ItemsBoutique;
import com.example.demo.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemsBoutiqueRepo extends JpaRepository<ItemsBoutique, Long> {
    Optional<ItemsBoutique> findItemsBoutiqueById(Long id);

 }
