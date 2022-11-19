package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class ServiceImages implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinTable(name = "service_serviceimages",
            joinColumns = @JoinColumn(name = "serviceimage_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Service service;

    public ServiceImages(String name) {
        this.name = name;
    }
}
