package fr.michot.video.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.michot.video.beans.Acteur;
import fr.michot.video.repositories.ActeurRepository;

@Controller
@RequestMapping("/acteur")
public class ActeurService {
	@Inject
	ActeurRepository repository;
	
	@Inject
	MongoOperations operations;
	
	@RequestMapping(value="nom/{nom}", method = RequestMethod.GET)
	public @ResponseBody List<Acteur>  getActeursParNom(@PathVariable String nom) {
		return repository.findByNom(nom);
	}
	
	@RequestMapping(value="id/{id}", method = RequestMethod.GET)
	public @ResponseBody Acteur  getActeurParId(@PathVariable String id) {
		return repository.findOne(id);
	}
	
	@RequestMapping(value="all", method = RequestMethod.GET)
	public @ResponseBody List<Acteur>  getAllActeurs() {
		ArrayList<Acteur> acteurs = new ArrayList<Acteur>();
		Iterable<Acteur> iter = repository.findAll();
		for (Acteur acteur : iter) {
			acteurs.add(acteur);
		}
		return acteurs;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Acteur setActeur(@RequestBody Acteur acteur) {
		// mise à jour des participations inutile en théorie grace aux dbrefs
		//operations.updateMulti(new Query(Criteria.where("participation.acteur.id").is(acteur.getId())), new Update().set("acteur", acteur), Participation.class);
		return repository.save(acteur);
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE)
	public @ResponseBody String deleteActeur(@PathVariable String id) {
		repository.delete(id);
		return id;
	}

}
