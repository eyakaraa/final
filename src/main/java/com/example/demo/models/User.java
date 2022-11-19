package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;


@NoArgsConstructor
@Setter
@Getter
//username and email unique use uniqueConstraint
@Entity
@Table(name="users",uniqueConstraints = {@UniqueConstraint(columnNames = "username"),@UniqueConstraint(columnNames = "email")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotBlank: to say that a string field must not be the empty string (i.e. it must have at least one character).
    @NotBlank
    @Size(max=20)
    private String username;
    private String lastName;
    private Date birthday;
    @NotBlank
    @Size(max=50)
    @Email
    private String email;
    @NotBlank
    @Size(max=120)
    private String password;
    //Java HashSet class is used to create a collection that uses a hash table for storage.
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_roles",
    joinColumns = @JoinColumn(name="user_id"))
    private Set<Role> roles = new HashSet<>();
    
    private String phoneNumber;
    private String address;
    @Basic
    private String image;


    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Evaluation> evaluations = new HashSet<>();

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Commande> commandes = new HashSet<>();

    @OneToMany
    private List<Service> employes = new ArrayList<>();
}
