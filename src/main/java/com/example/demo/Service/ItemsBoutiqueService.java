package com.example.demo.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.ItemsBoutique;
import com.example.demo.repository.ItemsBoutiqueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemsBoutiqueService {
    private final ItemsBoutiqueRepo ItemsBoutiqueRepo;
    @Autowired
    public ItemsBoutiqueService(ItemsBoutiqueRepo ItemsBoutiqueRepo) {
        this.ItemsBoutiqueRepo = ItemsBoutiqueRepo;
    }

    public ItemsBoutique addItemsBoutique(ItemsBoutique ItemsBoutique){
        return ItemsBoutiqueRepo.save(ItemsBoutique);
    }
    public List<ItemsBoutique> findAllItemsBoutique(){
        return ItemsBoutiqueRepo.findAll();
    }
    public ItemsBoutique updateItemsBoutique(ItemsBoutique ItemsBoutique){
        return ItemsBoutiqueRepo.save(ItemsBoutique);
    }
    public ItemsBoutique findItemsBoutiqueById(Long id){
        return ItemsBoutiqueRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));
    }
    public void deleteItemsBoutique(Long id){
        ItemsBoutiqueRepo.deleteById(id);
    }
}
