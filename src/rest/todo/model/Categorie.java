package rest.todo.model;
import java.util.ArrayList;
import rest.todo.model.Article;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Categorie {

    private Integer id;
    private String libelle;
    @JsonManagedReference
    private List<Article> articles;
    @JsonIgnore
    private List<Categorie> sousCategories;
    @JsonIgnore
    private List<Categorie> categoriesParent;


    public Categorie(Integer id, String libelle){
        this.id = id;
        this.libelle = libelle;
        this.articles = new ArrayList<Article>();
        this.sousCategories = new ArrayList<>();
        this.categoriesParent = new ArrayList<>();
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void addArticle(Article article){
        this.articles.add(article);
    }
    public void deleteArticle(Article article){
        this.articles.remove(article);
        article.removeCategorie(this);
    }
    public void addSousCategorie(Categorie categorie){
        this.sousCategories.add(categorie);
    }
    public void addCategorieParent(Categorie categorie){
        this.categoriesParent.add(categorie);
    }
    public void removeArticle(Article article) {
    	this.articles.remove(article);
    }
    public void removeCategorieParent(Categorie categorie) {
    	this.categoriesParent.remove(categorie);
    }
    public void removeSousCategorie(Categorie categorie) {
    	this.sousCategories.remove(categorie);
    }
    public List<Article> getArticles() {
        return articles;
    }

    public List<Categorie> getSousCategories() {
        return sousCategories;
    }

    public List<Categorie> getCategoriesParent() {
        return categoriesParent;
    }
}
