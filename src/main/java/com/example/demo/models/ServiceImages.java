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
    private Services service;

    public ServiceImages(String name) {
        this.name = name;
    }
    public ServiceImages( ) {
      
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}
    
}
