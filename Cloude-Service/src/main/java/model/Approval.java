package model;

public class Approval {
	
	private String nom;
	private String reponse;
	
	public Approval(String nom, String reponse) {
		this.nom = nom;
		this.reponse = reponse;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	public String getReponse() {
		return reponse;
	}

}
