package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class ItemsBoutique implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;

    @ManyToOne
    @JoinTable(name = "commande_itemsboutique",
            joinColumns = @JoinColumn(name = "itemsboutique_id"),
            inverseJoinColumns = @JoinColumn(name = "commande_id"))
    private Commande commande;


    @ManyToOne
    @JoinTable(name = "products_itemsboutique",
            joinColumns = @JoinColumn(name = "itemsboutique_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private Products products;

    public ItemsBoutique(Date date) {
        this.date = date;
    }
    public ItemsBoutique( ) {
             }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}
    
}
