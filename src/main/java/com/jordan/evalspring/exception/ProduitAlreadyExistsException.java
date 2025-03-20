package com.jordan.evalspring.exception;

public class ProduitAlreadyExistsException extends RuntimeException {
    public ProduitAlreadyExistsException(String nom) {
        super("Le produit avec le nom : (" + nom + ") existe déja!");
    }
}
