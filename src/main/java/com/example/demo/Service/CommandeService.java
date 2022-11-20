package com.example.demo.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Commande;
import com.example.demo.repository.CommandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommandeService {
    private final CommandeRepo CommandeRepo;
    @Autowired
    public CommandeService(CommandeRepo CommandeRepo) {
        this.CommandeRepo = CommandeRepo;
    }

    public Commande addCommande(Commande Commande){
        return CommandeRepo.save(Commande);
    }
    public List<Commande> findAllCommande(){
        return CommandeRepo.findAll();
    }
    public Commande updateCommande(Commande Commande){
        return CommandeRepo.save(Commande);
    }
    public Commande findCommandeById(Long id){
        return CommandeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));    }
    public void deleteCommande(Long id){
        CommandeRepo.deleteById(id);
    }
}
