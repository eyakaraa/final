package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@Table(name="reclamations")
@Entity
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reclamationObject;
    private String reclamationContent;
    @ManyToOne
    @JoinTable(name = "user_reclamation",
            joinColumns = @JoinColumn(name = "reclamation_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;

    public Reclamation(String reclamationObject, String reclamationContent) {
        this.reclamationObject = reclamationObject;
        this.reclamationContent = reclamationContent;
    }
    public Reclamation( ) {
      
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReclamationObject() {
		return reclamationObject;
	}

	public void setReclamationObject(String reclamationObject) {
		this.reclamationObject = reclamationObject;
	}

	public String getReclamationContent() {
		return reclamationContent;
	}

	public void setReclamationContent(String reclamationContent) {
		this.reclamationContent = reclamationContent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}
