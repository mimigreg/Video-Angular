package fr.michot.video.beans;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import fr.michot.video.beans.enums.Role;

public class Participation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 201453924249665946L;

	@DBRef
	private Film film;

	@Id
	private String id;

	@DBRef
	private Acteur acteur;

	private String precision;

	private Role role;

	public Film getFilm() {
		return film;
	}

	public String getId() {
		return id;
	}

	public Acteur getActeur() {
		return acteur;
	}

	public String getPrecision() {
		return precision;
	}

	public Role getRole() {
		return role;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Participation() {
		super();
	}

	public Participation(Film film, Acteur acteur, String precision, Role role) {
		super();
		this.film = film;
		this.acteur = acteur;
		this.precision = precision;
		this.role = role;
	}

}
