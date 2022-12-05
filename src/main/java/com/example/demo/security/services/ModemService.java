package com.example.demo.security.services;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.Modem;
import com.example.demo.models.User;
import com.example.demo.repository.ModemRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ModemService {
    private final ModemRepository ModemRepository;
    @Autowired
    public ModemService(ModemRepository ModemRepository) {
        this.ModemRepository = ModemRepository;
    }
    @Autowired
    UserRepository userRepository;

    public Modem addModem(Modem Modem,String username){
   	 User user = userRepository.findByUsername(username).get();
   	 Modem.setConseiller(username);
   	 Modem m = ModemRepository.save(Modem)	;	
   	 user.addProduit(m);
   	 userRepository.save(user);
        return m;
    }
    public List<Modem> findAllModem(String from,String to,String username) throws ParseException{
      	 User user = userRepository.findByUsername(username).get();
      	List<Modem> result = new ArrayList();
      	 if (user.getRole().equals("admin")) {
         	Date start = new SimpleDateFormat("yyyy-MM-dd").parse(from);
        	Date end = new SimpleDateFormat("yyyy-MM-dd").parse(to);
        	List<Modem> modems = ModemRepository.Bee(start,end);   
        	return modems;
      	 }
      	 else {
          	Date start = new SimpleDateFormat("yyyy-MM-dd").parse(from);
         	Date end = new SimpleDateFormat("yyyy-MM-dd").parse(to);
         	List<Modem> modems = ModemRepository.Bee(start,end);    	
         	for(Modem m : modems) {
         		if(m.getConseiller().equals(username)) {
         			result.add(m);
         		}
         	}
         	return result;
      	 }
    	
    }
    public Modem updateModem(Modem Modem){
        return ModemRepository.save(Modem);
    }
    public void dropdata(){
         ModemRepository.deleteAll();
    }
    public void dropSelecteddata(List<Modem> modems){
        ModemRepository.deleteAll(modems);
   }
    public Modem findModemById(Long id){
        return ModemRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource by id "+id+"was not found"));    }
    public void deleteModem(Long id){
        ModemRepository.deleteById(id);
    }
}
