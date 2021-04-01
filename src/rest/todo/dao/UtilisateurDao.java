package rest.todo.DAO;


import java.util.HashMap;


import rest.todo.model.Utilisateur;


public enum UtilisateurDAO {

    instance;

    private HashMap<Integer, Utilisateur> contentProvider = new HashMap<>();

    UtilisateurDAO(){
        Utilisateur admin = new Utilisateur("1", "username","test1@mail.com", "password","admin");
        contentProvider.put(1, admin);
        Utilisateur customer = new Utilisateur("2", "username2","test2@mail.com", "password2","customer");
        contentProvider.put(2, customer);
    }

    public HashMap<Integer, Utilisateur> getModel(){
        return contentProvider;
    }
}



