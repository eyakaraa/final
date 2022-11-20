package com.example.demo.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Services;
import com.example.demo.repository.ServicesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServicesService {
    private final ServicesRepo ServiceRepo;
    @Autowired
    public ServicesService(ServicesRepo ServiceRepo) {
        this.ServiceRepo = ServiceRepo;
    }

    public Services addService(Services Service){
        return ServiceRepo.save(Service);
    }
    public List<Services> findAllService(){
        return ServiceRepo.findAll();
    }
    public Services updateService(Services Service){
        return ServiceRepo.save(Service);
    }
    public Services findServiceById(Long id){
        return ServiceRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));
    }
    public void deleteService(Long id){
        ServiceRepo.deleteById(id);
    }
}
