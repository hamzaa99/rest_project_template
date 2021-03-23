package rest.todo.DAO;


import java.util.HashMap;

import rest.todo.model.Admin;
import rest.todo.model.Customer;
import rest.todo.model.Utilisateur;


public enum UtilisateurDAO {

    instance;

    private HashMap<Integer, Utilisateur> contentProvider = new HashMap<>();

    UtilisateurDAO(){
        Utilisateur admin = new Admin("1", "username", "password");
        contentProvider.put(1, admin);
        Utilisateur customer = new Customer("2", "username2", "password2");
        contentProvider.put(2, customer);
    }

    public HashMap<Integer, Utilisateur> getModel(){
        return contentProvider;
    }
}



