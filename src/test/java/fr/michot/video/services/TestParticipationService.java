package fr.michot.video.services;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.michot.video.beans.Acteur;
import fr.michot.video.beans.Film;
import fr.michot.video.beans.Participation;
import fr.michot.video.beans.enums.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testContext.xml")
public class TestParticipationService {

	@Inject
	ParticipationService service;
	
	@Inject
	ActeurService acteurService;
	
	@Inject
	FilmService filmService;
	
	@Test
	public void testCRUD() {
		Acteur acteur = new Acteur("Mel Gibson 2",true,"http://ia.media-imdb.com/images/M/MV5BNTUzOTMwNTM0OV5BMl5BanBnXkFtZTcwNDQwMTUxMw@@._V1._SY314_CR7,0,214,314_.jpg","");
		acteur = acteurService.setActeur(acteur);
		Acteur acteur2 = new Acteur("Rosanna Arquette 2",false,"http://ia.media-imdb.com/images/M/MV5BNTI0MjYxMzQ0OF5BMl5BanBnXkFtZTcwMTk0OTE3NQ@@._V1._SX214_CR0,0,214,314_.jpg","");
		acteur2 = acteurService.setActeur(acteur2);
		Acteur acteur3 = new Acteur("Keanu Reeves 2",true,"http://ia.media-imdb.com/images/M/MV5BNjUxNDcwMTg4Ml5BMl5BanBnXkFtZTcwMjU4NDYyOA@@._V1._SY314_CR14,0,214,314_.jpg","");
		acteur3 = acteurService.setActeur(acteur3);
		Film film = new Film("Mad Max 3",null,"http://ia.media-imdb.com/images/M/MV5BMTM4Mjg5ODEzMV5BMl5BanBnXkFtZTcwMDc3NDk0NA@@._V1_SX214_.jpg",5,null,"Il était une fois, sur la route...");
		film = filmService.setFilm(film);
		Film film2 = new Film("Le grand bleu 3",null,"http://ia.media-imdb.com/images/M/MV5BMjAwNDg5NzgzN15BMl5BanBnXkFtZTcwMjAxODgxMQ@@._V1_SY317_CR4,0,214,317_.jpg",5,null,"Il était une fois, dans l'eau...");
		film2 = filmService.setFilm(film2);
		Film film3 = new Film("Matrix 3",null,"http://ia.media-imdb.com/images/M/MV5BMjEzNjg1NTg2NV5BMl5BanBnXkFtZTYwNjY3MzQ5._V1_SY317_CR6,0,214,317_.jpg",5,null,"Il était une fois, dans le futur...");
		film3 = filmService.setFilm(film3);
		// Create
		// on prend comme principe que 0L est réservé aux tests unitaires
		Participation participation = new Participation(film,acteur,"Max",Role.ACTEUR);
		participation = service.setParticipation(participation);
		Participation participation2 = new Participation(film2,acteur2,"Johanna",Role.ACTEUR);
		participation2 = service.setParticipation(participation2);
		Participation participation3 = new Participation(film3,acteur3,"Neo",Role.ACTEUR);
		participation3 = service.setParticipation(participation3);
		Assert.assertNotNull("Le participation ne devrait pas être null",participation);
		Assert.assertNotEquals("Les identifiants devraient être différents", participation.getId(), participation2.getId());
		// Update
		participation3.setPrecision("Neo / Mr Anderson");		
		participation3 = service.setParticipation(participation3);

		// Research
		participation = service.getParticipationParId(participation3.getId());
		Assert.assertNotNull("Le participation devrait être trouve",participation);
		Assert.assertEquals("La note aurait du être modifié", "Neo / Mr Anderson", participation.getPrecision());
		
		// Delete
		service.deleteParticipation(participation3.getId());
		List<Participation> listeResultante = service.getParticipationsParFilmId(film3.getId());
		Assert.assertEquals("On devrait trouver une liste vide", 0,listeResultante.size());
		listeResultante = service.getParticipationsParActeurId(acteur2.getId());
		Assert.assertEquals("On devrait trouver le participation", 1,listeResultante.size());
	}
	
	@Test
	public void testDeleteAll() {
		List<Participation> liste = service.getAllParticipations();
		for (Iterator<Participation> iterator = liste.iterator(); iterator.hasNext();) {
			service.deleteParticipation(iterator.next().getId());
		}
		List<Participation> listeResultante = service.getAllParticipations();
		Assert.assertEquals("On devrait trouver une liste vide",0, listeResultante.size());		
	}

}
