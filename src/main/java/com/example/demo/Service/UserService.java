package com.example.demo.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Commande;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
 
@Service
@Transactional
public class UserService {
    private final UserRepository UserRepo;
    @Autowired
    public UserService(UserRepository UserRepo) {
        this.UserRepo = UserRepo;
    }

    public User addUser(User User){
        return UserRepo.save(User);
    }
    public List<User> findAllUser(){
        return UserRepo.findAll();
    }
    public User updateUser(User User){
        return UserRepo.save(User);
    }
    public User findUserById(Long id){
        return UserRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));
    }
    public void deleteUser(Long id){
        UserRepo.deleteById(id);
    }
}
