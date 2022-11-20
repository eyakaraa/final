package com.example.demo.repository;

import com.example.demo.models.Boutique;
import com.example.demo.models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EvaluationRepo extends JpaRepository<Evaluation, Long> {
    Optional<Evaluation> findEvaluationById(Long id);

 }
