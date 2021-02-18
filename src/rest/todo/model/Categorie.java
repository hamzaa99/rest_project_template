package rest.todo.model;



public class Categorie {
	
	private Integer id;
	private String libelle;
	
	public Categorie(Integer id, String libelle){
		this.id = id;
		this.libelle = libelle;
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
	
 
}
