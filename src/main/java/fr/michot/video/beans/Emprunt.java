package fr.michot.video.beans;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Emprunt implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4764055310219860267L;

	private DateTime date;

	@DBRef
	private Film film;

	@Id
	private String id;

	@DBRef
	private Personne personne;

	public DateTime getDate() {
		return date;
	}

	public Film getFilm() {
		return film;
	}

	public String getId() {
		return id;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
}
