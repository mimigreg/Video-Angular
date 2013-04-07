package fr.michot.video.beans;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Production implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5551664992016671907L;

	@Id
	private String id;

	private String logoUrl;

	private String nom;

	public String getId() {
		return id;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public String getNom() {
		return nom;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
