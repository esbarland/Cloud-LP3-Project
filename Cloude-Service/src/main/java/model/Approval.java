package model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Approval {
	@Id
	private Long id;
	private Long idAccount;
	private String reponse;
	
	public Approval() {}
	
	public Approval(Long idAccount, String reponse) {
		this.idAccount = idAccount;
		this.reponse = reponse;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setNom(Long idAccount) {
		this.idAccount = idAccount;
	}
	
	public Long getidAccount() {
		return idAccount;
	}
	
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	public String getReponse() {
		return reponse;
	}

}
