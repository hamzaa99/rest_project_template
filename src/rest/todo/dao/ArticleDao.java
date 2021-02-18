package rest.todo.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import rest.todo.model.Article;
import rest.todo.model.Categorie;


public enum ArticleDao {
    instance;

    private Map<String, Article> contentProvider = new HashMap<>();

    private ArticleDao() {
    	Article article = new Article("Libelle1", "marque1", 10.5, 1, "NoURL");
    	contentProvider.put("1", article);
    }
    
    public Map<String, Article> getModel(){
        return contentProvider;
    }
    
    public Map<String, Article> getArticlesByCategorie(Integer id){
        return contentProvider.entrySet().stream().filter(x -> x.getValue().getCategorie() == id).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}