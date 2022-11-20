package com.example.demo.repository;

import com.example.demo.models.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoutiqueRepo extends JpaRepository<Boutique, Long> {
    void deleteBoutiqueById(Long id);
    //Optional pour vérifier la présence d'un élément facultatif (d'un élément qui peut ne pas exister) avant de l'utiliser.
    Optional<Boutique> findBoutiqueById(Long id);
}
