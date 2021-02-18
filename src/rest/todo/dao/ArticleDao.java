package rest.todo.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import rest.todo.model.Article;


public enum ArticleDao {
    instance;

    private HashMap<Integer, Article> contentProvider = new HashMap<>();

    private ArticleDao() {
    	Article article = new Article(1, "Libelle1", "marque1", 10.5, 1, "NoURL");
    	contentProvider.put(article.getId(), article);
    }
    
    public HashMap<Integer, Article> getModel(){
        return contentProvider;
    }
    
    public Map<Integer, Article> getArticlesByCategorie(Integer id){
        return contentProvider.entrySet().stream().filter(x -> x.getValue().getCategorie() == id).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}