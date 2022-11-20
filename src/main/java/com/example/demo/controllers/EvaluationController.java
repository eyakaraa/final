package com.example.demo.controllers;

import com.example.demo.Service.EvaluationService;
import com.example.demo.models.Evaluation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
    private final EvaluationService EvaluationService;

    public EvaluationController(EvaluationService EvaluationService) {
        this.EvaluationService = EvaluationService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Evaluation>> getAllEvaluation(){
        //call the service that finds all tmm
        List<Evaluation> Evaluation=EvaluationService.findAllEvaluation();
        return new ResponseEntity<>(Evaluation, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Evaluation> getEvaluationById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        Evaluation Evaluation= EvaluationService.findEvaluationById(id);
        return new ResponseEntity<>(Evaluation, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Evaluation> addEvaluation(@RequestBody Evaluation Evaluation){
        Evaluation newEvaluation = EvaluationService.addEvaluation(Evaluation);
        return new ResponseEntity<>(newEvaluation,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Evaluation> updateEvaluation(@RequestBody Evaluation Evaluation, @PathVariable("id") Long id){
        Evaluation updateEvaluation = EvaluationService.updateEvaluation(Evaluation);
        return new ResponseEntity<>(updateEvaluation,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteEvaluation(@PathVariable("id") Long id){
        EvaluationService.deleteEvaluation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
