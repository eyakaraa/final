package com.example.demo.repository;

import com.example.demo.models.Modem;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 @Repository
public interface ModemRepository extends JpaRepository<Modem,Long> {
	    @Query("select a from Modem a where a.dateActivation BETWEEN :from AND :to ")
	    List<Modem> Bee(
	      @Param("from") Date from,@Param("to") Date to);
}
