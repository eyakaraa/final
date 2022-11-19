package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class ServiceImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinTable(name = "service_serviceimages",
            joinColumns = @JoinColumn(name = "serviceimage_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Service service;

}
