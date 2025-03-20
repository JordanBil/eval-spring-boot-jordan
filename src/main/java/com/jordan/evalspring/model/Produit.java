package com.jordan.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
 @Table(name="Produit")
 public class Produit {
 
     @Id
     @GeneratedValue(strategy= GenerationType.AUTO)
     private Long id;
 
     @Column(name = "nom", nullable = false)
     @NotBlank(message = "Le champ est vide, veuillez le remplir !")
     @Size(min = 2)
     private String nom;
 
     @Column(name="prix", nullable = false)
     @NotBlank(message = "Le champ est vide, veuillez le remplir !")
     @Positive(message = "Le nombre doit être un nombre positif supérieur à 0")
     private Double prix;
 
 }