package rest.todo.dao;



import java.util.ArrayList;
import java.util.HashMap;

import rest.todo.model.Article;
import rest.todo.model.Categorie;
import rest.todo.model.Utilisateur;


public enum UtilisateurDao {

    instance;

    private HashMap<Integer, Utilisateur> contentProvider = new HashMap<>();

    UtilisateurDao(){
        Utilisateur utilisateur = new Utilisateur("1", "username", "password");
        contentProvider.put(1, utilisateur);
    }

    public HashMap<Integer, Utilisateur> getModel(){
        return contentProvider;
    }
}



