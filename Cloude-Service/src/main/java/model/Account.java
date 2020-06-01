package model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Account {
	@Id
	private Long id;
	private String nom;
	private String prenom;
	private int amount;
	private String risk;
	
	public Account() {}
	
	public Account(String nom, String prenom, int amount, String risk) {
		this.nom = nom;
		this.prenom = prenom;
		this.amount = amount;
		this.risk = risk;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setRisk(String risk) {
		this.risk = risk;
	}
	
	public String getRisk() {
		return risk;
	}
	
}
