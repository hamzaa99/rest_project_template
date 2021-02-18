package rest.todo.dao;

import java.util.ArrayList;

import rest.todo.model.Categorie;


public enum CategorieDao {
    instance;

    private ArrayList<Categorie> contentProvider = new ArrayList<>();

    private CategorieDao() {
    	contentProvider.add(new Categorie(1, "PC Portable"));
    	contentProvider.add(new Categorie(2, "PC de Bureau"));
    	contentProvider.add(new Categorie(3, "Accessoires ordinateurs"));
    	contentProvider.add(new Categorie(4, "Smart phone"));
    	contentProvider.add(new Categorie(5, "Tel Fixe"));
    	contentProvider.add(new Categorie(6, "Accessoires téléphone"));
    	contentProvider.add(new Categorie(7, "Disque dur"));
    	contentProvider.add(new Categorie(8, "Clé USB"));
    	contentProvider.add(new Categorie(9, "Accessoires stockage"));
    }
    
    public ArrayList<Categorie> getModel(){
        return contentProvider;
    }

}