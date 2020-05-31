package model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Approval {
	@Id
	private Long id;
	private String nom;
	private String reponse;
	
	public Approval() {}
	
	public Approval(String nom, String reponse) {
		this.nom = nom;
		this.reponse = reponse;
	}
	
	public void setId(Long id) {
		this.id = id;
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
