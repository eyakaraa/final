package com.example.demo.repository;

import com.example.demo.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeRepo extends JpaRepository<Commande, Long> {
    void deleteCommandeById(Long id);
    //Optional pour vérifier la présence d'un élément facultatif (d'un élément qui peut ne pas exister) avant de l'utiliser.
    Optional<Commande> findCommandeById(Long id);
}
