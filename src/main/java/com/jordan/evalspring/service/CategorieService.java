package com.jordan.evalspring.service;

import com.jordan.evalspring.exception.*;
import com.jordan.evalspring.model.Categorie;
import com.jordan.evalspring.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {

        if(categorieRepository.count() == 0) {
            throw new CategoriesNotFoundException();
        }

        List<Categorie> categories = new ArrayList<>();
        for (Categorie categorie : categorieRepository.findAll()) {
            categories.add(categorie);
        }

        return categories;
    }

    public Categorie getCategorieById(Long id) {

        if(categorieRepository.findById(id).isEmpty()){
            throw new CategorieNotFoundException(id);
        };

        return categorieRepository.findById(id).get();
    }

    public Categorie saveCategorie(Categorie newCategorie) {
         List<Categorie> categories = getAllCategories();
         for (Categorie categorie : categories) {
             if(categorie.getLibelle().equals(newCategorie.getLibelle())){
                 throw new CategorieAlreadyExistsException(newCategorie.getLibelle());
             }
         }
         return categorieRepository.save(newCategorie);
     }
}
