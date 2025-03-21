package com.jordan.evalspring.controller;

import com.jordan.evalspring.model.Categorie;
import com.jordan.evalspring.model.Produit;
import com.jordan.evalspring.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/produits")
    @ResponseStatus(HttpStatus.OK)
    public List<Produit> getProduits() {
        return produitService.getAllProduits();
    }
    @GetMapping("/produit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produit getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    @PostMapping("/produit")
    @ResponseStatus(HttpStatus.CREATED)
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }
}
