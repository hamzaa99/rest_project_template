package rest.todo.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import rest.todo.model.Article;
import rest.todo.model.Categorie;


public enum ArticleDao {
    instance;

    private HashMap<Integer, Article> contentProvider = new HashMap<>();

    private ArticleDao() {
    	Article article = new Article(1, "Libelle1", "marque1", 10.5, "NoURL");
    	article.addCategorie(CategorieDao.instance.getModel().get(3));
    	article.addCategorie(CategorieDao.instance.getModel().get(2));

    	contentProvider.put(1, article);

    }
    
    public HashMap<Integer, Article> getModel(){
        return contentProvider;
    }
    
    public Map<Integer, Article> getArticlesByCategorie(Categorie categorie){
        return contentProvider.entrySet().stream().filter(x -> x.getValue().getCategories().contains(categorie)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}