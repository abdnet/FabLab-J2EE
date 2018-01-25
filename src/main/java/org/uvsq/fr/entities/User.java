package org.uvsq.fr.entities;

import javax.persistence.*;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long idUser;
	private String nom;
	private String prenom;
	public User() {
		
	}
	public User( String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	public Long getIdUser() {
		return idUser;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

}
