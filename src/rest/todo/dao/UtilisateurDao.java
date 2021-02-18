package rest.todo.dao;



import java.util.ArrayList;
import java.util.HashMap;

import rest.todo.model.Categorie;
import rest.todo.model.Utilisateur;


public enum UtilisateurDao {

    instance;

    private HashMap<Integer, Article> contentProvider = new HashMap<>();

    public UtilisateurDao(){
        Utilisateur utilisateur = new Utilisateur("id", "username", "password");
    }

    public HashMap<Integer, Categorie> getModel(){
        return contentProvider;
    }
}



