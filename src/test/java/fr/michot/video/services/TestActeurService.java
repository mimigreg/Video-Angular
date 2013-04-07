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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testContext.xml")
public class TestActeurService {

	@Inject
	ActeurService service;
	
	@Test
	public void testCRUD() {
		// Create
		// on prend comme principe que 0L est réservé aux tests unitaires
		Acteur acteur = new Acteur("Mel Gibson",true,"http://ia.media-imdb.com/images/M/MV5BNTUzOTMwNTM0OV5BMl5BanBnXkFtZTcwNDQwMTUxMw@@._V1._SY314_CR7,0,214,314_.jpg","");
		acteur = service.setActeur(acteur);
		Acteur acteur2 = new Acteur("Rosanna Arquette",false,"http://ia.media-imdb.com/images/M/MV5BNTI0MjYxMzQ0OF5BMl5BanBnXkFtZTcwMTk0OTE3NQ@@._V1._SX214_CR0,0,214,314_.jpg","");
		acteur2 = service.setActeur(acteur2);
		Acteur acteur3 = new Acteur("Keanu Reeves",true,"http://ia.media-imdb.com/images/M/MV5BNjUxNDcwMTg4Ml5BMl5BanBnXkFtZTcwMjU4NDYyOA@@._V1._SY314_CR14,0,214,314_.jpg","");
		acteur3 = service.setActeur(acteur3);
		Assert.assertNotNull("Le acteur ne devrait pas être null",acteur);
		Assert.assertNotEquals("Les identifiants devraient être différents", acteur.getId(), acteur2.getId());
		// Update
		acteur3.setAnnotations("1");
		acteur3 = service.setActeur(acteur3);

		// Research
		acteur = service.getActeurParId(acteur3.getId());
		Assert.assertNotNull("Le acteur devrait être trouve",acteur);
		Assert.assertEquals("La note aurait du être modifié", "1", acteur.getAnnotations());
		
		// Delete
		service.deleteActeur(acteur.getId());
		List<Acteur> listeResultante = service.getActeursParNom("Keanu Reeves");
		Assert.assertEquals("On devrait trouver une liste vide", 0,listeResultante.size());
		listeResultante = service.getActeursParNom("Mel Gibson");
		Assert.assertEquals("On devrait trouver le acteur", 1,listeResultante.size());
	}
	
	@Test
	public void testDeleteAll() {
		List<Acteur> liste = service.getAllActeurs();
		for (Iterator<Acteur> iterator = liste.iterator(); iterator.hasNext();) {
			service.deleteActeur(iterator.next().getId());
		}
		List<Acteur> listeResultante = service.getAllActeurs();
		Assert.assertEquals("On devrait trouver une liste vide",0, listeResultante.size());		
	}

}
