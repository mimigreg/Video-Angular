package fr.michot.video.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.michot.video.beans.Personne;
import fr.michot.video.repositories.PersonneRepository;

@Controller
@RequestMapping("/personne")
public class PersonneService {
	@Inject
	PersonneRepository repository;
	
	@RequestMapping(value="nom/{nom}", method = RequestMethod.GET)
	public @ResponseBody List<Personne>  getPersonnesParNom(@PathVariable String nom) {
		return repository.findByNom(nom);
	}
	
	@RequestMapping(value="id/{id}", method = RequestMethod.GET)
	public @ResponseBody Personne  getPersonneParId(@PathVariable String id) {
		return repository.findOne(id);
	}
	
	@RequestMapping(value="all", method = RequestMethod.GET)
	public @ResponseBody List<Personne>  getAllPersonnes() {
		ArrayList<Personne> personnes = new ArrayList<Personne>();
		Iterable<Personne> iter = repository.findAll();
		for (Personne personne : iter) {
			personnes.add(personne);
		}
		return personnes;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Personne setPersonne(@RequestBody Personne Personne) {
		return repository.save(Personne);
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE)
	public @ResponseBody String deletePersonne(@PathVariable String id) {
		repository.delete(id);
		return id;
	}

}
