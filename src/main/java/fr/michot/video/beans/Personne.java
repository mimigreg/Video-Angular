package fr.michot.video.beans;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Personne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4981189366351181612L;

	private String annotations;

	private Boolean homme;

	@Id
	private String id;

	private String nom;

	private String photoUrl;

	private String prenom;

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

	public String getPrenom() {
		return prenom;
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

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
