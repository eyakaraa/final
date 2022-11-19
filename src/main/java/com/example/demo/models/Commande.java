package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="commandes")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double totalPrice;
    private Date createdAt;
    private String status;
    private String deliveryAddress;
    private String paymentMethod;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "commandes_users",
            joinColumns = {
                    @JoinColumn(name = "commande_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<User> users = new HashSet<>();

    @OneToMany
    private List<Items> items = new ArrayList<>();

    public Commande(double totalPrice, Date createdAt, String status, String deliveryAddress, String paymentMethod) {
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.status = status;
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
    }
}
