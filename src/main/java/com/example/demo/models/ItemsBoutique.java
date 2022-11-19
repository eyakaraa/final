package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class ItemsBoutique {
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
}
