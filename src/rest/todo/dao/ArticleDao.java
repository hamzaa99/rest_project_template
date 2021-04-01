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
        Article article = new Article(1, "PC portable", "HP", 900.5, "https://d1eh9yux7w8iql.cloudfront.net/product_images/302929_723f26b0-44c9-4041-8e44-ff6a1cb62ace.jpg");
        article.addCategorie(CategorieDAO.instance.getModel().get(1));
        Article article2 = new Article(2, "PC bureau", "marque2", 1026.5, "https://d1eh9yux7w8iql.cloudfront.net/product_images/1460370107.83.jpg");
        article2.addCategorie(CategorieDAO.instance.getModel().get(2));
        Article article3 = new Article(3, "Accessoire d'ordinateur", "marque3", 26.5, "https://images-na.ssl-images-amazon.com/images/I/61dZNcZAGnL._AC_SX679_.jpg");
        Article article4 = new Article(4, "Iphone", "Apple", 826.5, "https://d1eh9yux7w8iql.cloudfront.net/product_images/326956_f8345bd8-8dc5-4135-be98-8ba38f9accc4.jpg");
        Article article5 = new Article(5, "Telephone fix", "marque3", 32.5, "https://static.fnac-static.com/multimedia/Images/87/87/8F/7C/8163207-1505-1505-1/tsp20200810190707/Gigaset-A170-Solo-Telephone-fixe-sans-fil-DECT-GAP-Noir.jpg");
        Article article6 = new Article(6, "chargeur Iphone", "marque2", 35.5, "NoURL");
        Article article7 = new Article(7, "Disque dur 500 GO", "samsung", 80.5, "NoURL");
        Article article8 = new Article(8, "Clé usb", "hp", 22.5, "NoURL");
        Article article9 = new Article(9, "Accessoires stockage", "marque2", 28.5, "NoURL");
        article3.addCategorie(CategorieDAO.instance.getModel().get(3));
        article4.addCategorie(CategorieDAO.instance.getModel().get(4));
        article5.addCategorie(CategorieDAO.instance.getModel().get(5));
        article6.addCategorie(CategorieDAO.instance.getModel().get(6));
        article7.addCategorie(CategorieDAO.instance.getModel().get(7));
        article8.addCategorie(CategorieDAO.instance.getModel().get(8));
        article9.addCategorie(CategorieDAO.instance.getModel().get(9));




        contentProvider.put(1, article);
        contentProvider.put(2, article2);
        contentProvider.put(3, article3);
        contentProvider.put(4, article4);
        contentProvider.put(5, article5);
        contentProvider.put(6, article6);
        contentProvider.put(7, article7);
        contentProvider.put(8, article8);
        contentProvider.put(9, article9);



    }

    public HashMap<Integer, Article> getModel(){
        return contentProvider;
    }

    public Map<Integer, Article> getArticlesByCategorie(Categorie categorie){
        return contentProvider.entrySet().stream().filter(x -> x.getValue().getCategories().contains(categorie)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}