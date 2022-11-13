package com.example.demo.security.services;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//UserDetailsService interface has only one method(loadUserByUsername()).So we implement it and override loadUserByUsername() method.
public class UserDetailsServiceImpl implements UserDetailsService {
   //It allows Spring to resolve and inject collaborating beans into our bean.
    @Autowired
   UserRepository userRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User Not Found with username: "+username));
       //build a UserDetails object using static build() method.
        return UserDetailsImpl.build(user);
    }
}
