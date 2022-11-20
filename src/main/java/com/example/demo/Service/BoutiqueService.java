package com.example.demo.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Boutique;
import com.example.demo.repository.BoutiqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BoutiqueService {
    private final BoutiqueRepo BoutiqueRepo;
    @Autowired
    public BoutiqueService(BoutiqueRepo BoutiqueRepo) {
        this.BoutiqueRepo = BoutiqueRepo;
    }

    public Boutique addBoutique(Boutique Boutique){
        return BoutiqueRepo.save(Boutique);
    }
    public List<Boutique> findAllBoutique(){
        return BoutiqueRepo.findAll();
    }
    public Boutique updateBoutique(Boutique Boutique){
        return BoutiqueRepo.save(Boutique);
    }
    public Boutique findBoutiqueById(Long id){
        return BoutiqueRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));    }
    public void deleteBoutique(Long id){
        BoutiqueRepo.deleteById(id);
    }
}
