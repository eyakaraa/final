package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String promotion;
    private double price;
    //images
    private int stock;
    private boolean availability;
    private String promoted;

    @OneToMany
    private List<ProductImages> productImages = new ArrayList<>();
}
