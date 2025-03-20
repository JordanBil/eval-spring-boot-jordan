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

     @ManyToOne
     @JoinColumn(name="id_categorie")
     private Categorie categorie;

     public Produit() {}
 
     public Produit(String nom, Double prix) {
         this.nom = nom;
         this.prix = prix;
     }
 
     public Produit(String nom, Double prix, Categorie categorie) {
         this.nom = nom;
         this.prix = prix;
         this.categorie = categorie;
     }
 
     public Long getId() {
         return id;
     }
 @@ -54,12 +64,21 @@ public void setPrix(Double prix) {
         this.prix = prix;
     }
 
     public Categorie getCategorie() {
         return categorie;
     }
 
     public void setCategorie(Categorie categorie) {
         this.categorie = categorie;
     }
 
     @Override
     public String toString() {
         return "Produit{" +
                 "id=" + id +
                 ", nom='" + nom + '\'' +
                 ", prix=" + prix +
                 ", categorie=" + categorie.toString() +
                 '}';
     }
 
 }