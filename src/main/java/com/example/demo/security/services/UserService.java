package com.example.demo.security.services;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.ERole;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
@Service
@Transactional
public class UserService {
    private final UserRepository UserRepo;
    @Autowired
    public UserService(UserRepository UserRepo) {
        this.UserRepo = UserRepo;
    }
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    public User addUser(User user){
    	 
         
         user.setPassword(encoder.encode(user.getPassword()));
        return UserRepo.save(user);
    }
    public List<User> findAllUser(){
        return UserRepo.findAll();
    }
    public User updateUser(User user){
    	  
        user.setPassword(encoder.encode(user.getPassword()));
        return UserRepo.save(user);
    }
    public User findUserById(Long id){
        return UserRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));
    }
    public void deleteUser(Long id){
        UserRepo.deleteById(id);
    }
}
