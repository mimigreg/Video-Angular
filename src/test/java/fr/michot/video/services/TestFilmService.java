package fr.michot.video.services;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.michot.video.beans.Film;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testContext.xml")
public class TestFilmService {

	@Inject
	FilmService service;
	
	@Test
	public void testCRUD() {
		// Create
		// on prend comme principe que 0L est réservé aux tests unitaires
		Film film = new Film("Mad Max",null,"http://ia.media-imdb.com/images/M/MV5BMTM4Mjg5ODEzMV5BMl5BanBnXkFtZTcwMDc3NDk0NA@@._V1_SX214_.jpg",5,null,"Il était une fois, sur la route...");
		film = service.setFilm(film);
		Film film2 = new Film("Le grand bleu",null,"http://ia.media-imdb.com/images/M/MV5BMjAwNDg5NzgzN15BMl5BanBnXkFtZTcwMjAxODgxMQ@@._V1_SY317_CR4,0,214,317_.jpg",5,null,"Il était une fois, dans l'eau...");
		film2 = service.setFilm(film2);
		Film film3 = new Film("Matrix",null,"http://ia.media-imdb.com/images/M/MV5BMjEzNjg1NTg2NV5BMl5BanBnXkFtZTYwNjY3MzQ5._V1_SY317_CR6,0,214,317_.jpg",5,null,"Il était une fois, dans le futur...");
		film3 = service.setFilm(film3);
		Assert.assertNotNull("Le film ne devrait pas être null",film);
		Assert.assertNotEquals("Les identifiants devraient être différents", film.getId(), film2.getId());
		// Update
		film3.setNote(3);		
		film3 = service.setFilm(film3);

		// Research
		film = service.getFilmParId(film3.getId());
		Assert.assertNotNull("Le film devrait être trouve",film);
		Assert.assertEquals("La note aurait du être modifié", 3, film.getNote());
		
		// Delete
		service.deleteFilm(film.getId());
		List<Film> listeResultante = service.getFilmsParTitre("Matrix");
		Assert.assertEquals("On devrait trouver une liste vide", 0,listeResultante.size());
		listeResultante = service.getFilmsParTitre("Mad Max");
		Assert.assertEquals("On devrait trouver le film", 1,listeResultante.size());
	}
	
	@Test
	public void testDeleteAll() {
		List<Film> liste = service.getAllFilms();
		for (Iterator<Film> iterator = liste.iterator(); iterator.hasNext();) {
			service.deleteFilm(iterator.next().getId());
		}
		List<Film> listeResultante = service.getAllFilms();
		Assert.assertEquals("On devrait trouver une liste vide",0, listeResultante.size());		
	}

}
