package com.example.demo.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Evaluation;
import com.example.demo.repository.EvaluationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EvaluationService {
    private final EvaluationRepo EvaluationRepo;
    @Autowired
    public EvaluationService(EvaluationRepo EvaluationRepo) {
        this.EvaluationRepo = EvaluationRepo;
    }

    public Evaluation addEvaluation(Evaluation Evaluation){
        return EvaluationRepo.save(Evaluation);
    }
    public List<Evaluation> findAllEvaluation(){
        return EvaluationRepo.findAll();
    }
    public Evaluation updateEvaluation(Evaluation Evaluation){
        return EvaluationRepo.save(Evaluation);
    }
    public Evaluation findEvaluationById(Long id){
        return EvaluationRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));
    }
    public void deleteEvaluation(Long id){
        EvaluationRepo.deleteById(id);
    }
}
