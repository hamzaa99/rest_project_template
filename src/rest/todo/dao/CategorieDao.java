package rest.todo.dao;

import java.util.ArrayList;
import java.util.HashMap;

import rest.todo.model.Categorie;


public enum CategorieDao {
    instance;

    private HashMap<Integer, Categorie> contentProvider = new HashMap<>();

    private CategorieDao() {
    	contentProvider.put(1, new Categorie(1, "PC Portable"));
    	contentProvider.put(2, new Categorie(2, "PC de Bureau"));
    	contentProvider.put(3, new Categorie(3, "Accessoires ordinateurs"));
    	contentProvider.put(4, new Categorie(4, "Smart phone"));
    	contentProvider.put(5, new Categorie(5, "Tel Fixe"));
    	contentProvider.put(6, new Categorie(6, "Accessoires téléphone"));
    	contentProvider.put(7, new Categorie(7, "Disque dur"));
    	contentProvider.put(8, new Categorie(8, "Clé USB"));
    	contentProvider.put(9, new Categorie(9, "Accessoires stockage"));
    }
    
    public HashMap<Integer, Categorie> getModel(){
        return contentProvider;
    }

}