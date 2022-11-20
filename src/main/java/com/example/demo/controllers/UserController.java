package com.example.demo.controllers;

import com.example.demo.Service.UserService;
import com.example.demo.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        //call the service that finds all tmm
        List<User> User=UserService.findAllUser();
        return new ResponseEntity<>(User, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        //call the service that finds all tmm
        User User= UserService.findUserById(id);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User User){
        User newUser = UserService.addUser(User);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User User, @PathVariable("id") Long id){
        User updateUser = UserService.updateUser(User);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        UserService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
