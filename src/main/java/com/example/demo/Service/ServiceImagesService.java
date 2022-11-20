package com.example.demo.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.ServiceImages;
import com.example.demo.repository.ServiceImagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceImagesService {
    private final ServiceImagesRepo ServiceImagesRepo;
    @Autowired
    public ServiceImagesService(ServiceImagesRepo ServiceImagesRepo) {
        this.ServiceImagesRepo = ServiceImagesRepo;
    }

    public ServiceImages addServiceImages(ServiceImages ServiceImages){
        return ServiceImagesRepo.save(ServiceImages);
    }
    public List<ServiceImages> findAllServiceImages(){
        return ServiceImagesRepo.findAll();
    }
    public ServiceImages updateServiceImages(ServiceImages ServiceImages){
        return ServiceImagesRepo.save(ServiceImages);
    }
    public ServiceImages findServiceImagesById(Long id){
        return ServiceImagesRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));
    }
    public void deleteServiceImages(Long id){
        ServiceImagesRepo.deleteById(id);
    }
}
