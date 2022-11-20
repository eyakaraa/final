package com.example.demo.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Items;
import com.example.demo.repository.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemsService {
    private final ItemsRepo ItemsRepo;
    @Autowired
    public ItemsService(ItemsRepo ItemsRepo) {
        this.ItemsRepo = ItemsRepo;
    }

    public Items addItems(Items Items){
        return ItemsRepo.save(Items);
    }
    public List<Items> findAllItems(){
        return ItemsRepo.findAll();
    }
    public Items updateItems(Items Items){
        return ItemsRepo.save(Items);
    }
    public Items findItemsById(Long id){
        return ItemsRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));
    }
    public void deleteItems(Long id){
        ItemsRepo.deleteById(id);
    }
}
