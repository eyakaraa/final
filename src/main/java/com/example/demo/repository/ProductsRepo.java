package com.example.demo.repository;

import com.example.demo.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepo extends JpaRepository<Products, Long> {
    void deleteProductsById(Long id);
    //Optional pour vérifier la présence d'un élément facultatif (d'un élément qui peut ne pas exister) avant de l'utiliser.
    Optional<Products> findProductById(Long id);
}
