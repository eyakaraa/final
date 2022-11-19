package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    // a verifier
    private String promotion;
    private float price;
    //images
    //timeRange
    //avatar
    private Boolean availability;
    //promoted
    //a completer

    public Service(String name, String description, Date createdAt, Date updatedAt, String promotion, float price, Boolean availability) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.promotion = promotion;
        this.price = price;
        this.availability = availability;
    }
}
