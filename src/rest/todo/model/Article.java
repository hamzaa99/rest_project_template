package rest.todo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;

import rest.todo.DAO.ArticleDAO;
import rest.todo.DAO.CategorieDAO;


public class Article {
    private int id;
    private String libelle;
    private String marque;
	private String id_categorie;
    private Double prix;
    @JsonIgnore
    private List<Categorie> categories;
    private String photo; //URL de la photo

    public Article(int id, String libelle, String marque, Double prix, String photo){
        this.setId(id);
        this.libelle = libelle;
        this.marque = marque;
        this.prix = prix;
        this.photo = photo;
        this.categories=new ArrayList<Categorie>();
    }

    public Article(int id, String libelle, String marque, Double prix){
        this.setId(id);
        this.libelle = libelle;
        this.marque = marque;
        this.prix = prix;
        this.categories = new ArrayList<Categorie>();
    }
    public Article() {
    	this.categories = new ArrayList<Categorie>();
    	this.id = ArticleDAO.instance.getModel().keySet().stream().max(Integer::compare).get();
    }
    


    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public Double getPrix() {
        return prix;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }
    public List<Categorie> getCategories() {
        return categories;
    }
    public void addCategorie(Categorie categorie) {
        this.categories.add(categorie);
       categorie.addArticle(this);
       System.out.println("categorie : "+categorie.getId()+" ajout� !!");
    }
    public void removeCategorie(Categorie categorie) {
    	this.categories.remove(categorie);
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	public String getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(String id_categorie) {
		this.id_categorie = id_categorie;
	}
	


}
