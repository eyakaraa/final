package com.example.demo.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Reclamation;
import com.example.demo.repository.ReclamationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReclamationService {
    private final ReclamationRepo ReclamationRepo;
    @Autowired
    public ReclamationService(ReclamationRepo ReclamationRepo) {
        this.ReclamationRepo = ReclamationRepo;
    }

    public Reclamation addReclamation(Reclamation Reclamation){
        return ReclamationRepo.save(Reclamation);
    }
    public List<Reclamation> findAllReclamation(){
        return ReclamationRepo.findAll();
    }
    public Reclamation updateReclamation(Reclamation Reclamation){
        return ReclamationRepo.save(Reclamation);
    }
    public Reclamation findReclamationById(Long id){
        return ReclamationRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));
    }
    public void deleteReclamation(Long id){
        ReclamationRepo.deleteById(id);
    }
}
