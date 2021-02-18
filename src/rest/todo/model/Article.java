package rest.todo.model;

public class Article {
	private int id;
	private String libelle;
	private String marque;
	private Double prix;
	private Integer categorie;
	private String photo; //URL de la photo
	
	public Article(int id, String libelle, String marque, Double prix, Integer categorie, String photo){
		this.id = id;
		this.libelle = libelle;
		this.marque = marque;
		this.prix = prix;
		this.categorie = categorie;
		this.photo = photo;
	}
	
	public Article(int id, String libelle, String marque, Double prix, Integer categorie){
		this.id = id;
		this.libelle = libelle;
		this.marque = marque;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getCategorie() {
		return categorie;
	}
	public void setCategorie(Integer categorie) {
		this.categorie = categorie;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
