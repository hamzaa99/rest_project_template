package rest.todo.DAO;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import rest.todo.model.Article;
import rest.todo.model.Categorie;
import rest.todo.DAO.CategorieDAO;

public enum ArticleDAO {
    instance;

    private HashMap<Integer, Article> contentProvider = new HashMap<>();

    private ArticleDAO() {
        Article article = new Article(1, "Libelle1", "marque1", 10.5, "NoURL");
        article.addCategorie(CategorieDAO.instance.getModel().get(1));
        Article article2 = new Article(2, "Libelle2", "marque2", 26.5, "NoURL");
        article2.addCategorie(CategorieDAO.instance.getModel().get(1));
        contentProvider.put(1, article);
        contentProvider.put(2, article2);


    }

    public HashMap<Integer, Article> getModel(){
        return contentProvider;
    }

    public Map<Integer, Article> getArticlesByCategorie(Categorie categorie){
        return contentProvider.entrySet().stream().filter(x -> x.getValue().getCategories().contains(categorie)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}