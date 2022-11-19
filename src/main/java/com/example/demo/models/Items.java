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
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;

    @ManyToOne
    @JoinTable(name = "commande_items",
            joinColumns = @JoinColumn(name = "items_id"),
            inverseJoinColumns = @JoinColumn(name = "commande_id"))
    private Commande commande;
}
