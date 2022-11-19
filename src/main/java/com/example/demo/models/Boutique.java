package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Boutique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date createdAT;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerBirthday;
    @Email
    private String ownerEmail;
    // batinda à voir
    private String ownerPhoneNumber;
    //avatar
    // a verifier
    private Boolean availability;
    private String createdBy;
    private String offerType;
    //resto, ..
    private String type;
    //address
    private String Location;
    private String status;
    private String promoted;
    //a compléter

    @OneToMany
    private List<Products> products = new ArrayList<>();

}
