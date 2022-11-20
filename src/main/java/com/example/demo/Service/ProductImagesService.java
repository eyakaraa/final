package com.example.demo.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.ProductImages;
import com.example.demo.repository.ProductImagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductImagesService {
    private final ProductImagesRepo ProductImagesRepo;
    @Autowired
    public ProductImagesService(ProductImagesRepo ProductImagesRepo) {
        this.ProductImagesRepo = ProductImagesRepo;
    }

    public ProductImages addProductImages(ProductImages ProductImages){
        return ProductImagesRepo.save(ProductImages);
    }
    public List<ProductImages> findAllProductImages(){
        return ProductImagesRepo.findAll();
    }
    public ProductImages updateProductImages(ProductImages ProductImages){
        return ProductImagesRepo.save(ProductImages);
    }
    public ProductImages findProductImagesById(Long id){
        return ProductImagesRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));
    }
    public void deleteProductImages(Long id){
        ProductImagesRepo.deleteById(id);
    }
}
