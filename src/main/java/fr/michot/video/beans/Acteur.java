package fr.michot.video.beans;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Acteur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -592932775752316203L;

	private String annotations;

	private Boolean homme;

	@Id
	private String id;

	private String nom;

	private String photoUrl;

	public String getAnnotations() {
		return annotations;
	}

	public String getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public Boolean getHomme() {
		return homme;
	}

	public void setAnnotations(String annotations) {
		this.annotations = annotations;
	}

	public void setHomme(Boolean homme) {
		this.homme = homme;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Acteur(String nom, Boolean homme, 
			String photoUrl, String annotations) {
		super();
		this.annotations = annotations;
		this.homme = homme;
		this.nom = nom;
		this.photoUrl = photoUrl;
	}

	public Acteur() {
		super();
	}
}
