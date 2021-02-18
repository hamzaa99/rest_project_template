package rest.todo.model;

public class Article {
	
	private String libelle;
	private String marque;
	private Double prix;
	private Categorie categorie;
	private String photo; //URL de la photo
	
	public Article(String libelle,String marque,Double prix,Categorie categorie,String photo){
		this.libelle=libelle;
		this.marque=marque;
		this.prix=prix;
		this.categorie=categorie;
		this.photo=photo;
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
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
