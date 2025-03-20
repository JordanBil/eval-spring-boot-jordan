package com.jordan.evalspring.exception;

public class ProduitsNotFoundException extends RuntimeException {
    public ProduitsNotFoundException() {
        super("Aucun produit n'a été trouvé");
    }
}
