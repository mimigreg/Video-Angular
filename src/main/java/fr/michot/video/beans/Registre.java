package fr.michot.video.beans;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import fr.michot.video.beans.enums.Type;

public class Registre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8716112448460906064L;

	@DBRef
	private Film film;

	@Id
	private String id;

	private int poids;

	private Type type;

	public Film getFilm() {
		return film;
	}

	public String getId() {
		return id;
	}

	public int getPoids() {
		return poids;
	}

	public Type getType() {
		return type;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
