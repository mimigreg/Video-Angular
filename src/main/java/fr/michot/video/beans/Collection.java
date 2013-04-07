package fr.michot.video.beans;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Collection implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8441193474455910701L;
	
	@Id
	private String id;
	
	private String titre;

	public String getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}
