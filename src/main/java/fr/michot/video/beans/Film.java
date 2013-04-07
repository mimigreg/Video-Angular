package fr.michot.video.beans;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Entity implementation class for Entity: Film
 * 
 */
public class Film implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -465555090850940774L;

	@DBRef
	private Collection collection;

	@Id
	private String id;

	private String imageUrl;

	private int note;

	@DBRef
	private Production production;

	private String resume;

	private String titre;

	public Film() {
		super();
	}

	public Collection getCollection() {
		return collection;
	}

	public String getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public int getNote() {
		return note;
	}

	public Production getProduction() {
		return production;
	}

	public String getResume() {
		return resume;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Film(String titre,Collection collection, String imageUrl, int note,
			Production production, String resume) {
		super();
		this.collection = collection;
		this.imageUrl = imageUrl;
		this.note = note;
		this.production = production;
		this.resume = resume;
		this.titre = titre;
	}

}
