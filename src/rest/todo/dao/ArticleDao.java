package rest.todo.dao;

import java.util.HashMap;
import java.util.Map;

import rest.todo.model.Article;
import rest.todo.model.Categorie;


public enum ArticleDao {
    instance;

    private Map<String, Article> contentProvider = new HashMap<>();

    private ArticleDao() {
    	
    	Article article = new Article("Libelle1", "marque1",10.5, Categorie.Accessoire_Ordinateur, "NoURL");
    	contentProvider.put("1", article);
      
    }
    public Map<String, Article> getModel(){
        return contentProvider;
    }

}