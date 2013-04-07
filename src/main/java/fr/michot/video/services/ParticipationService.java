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

import fr.michot.video.beans.Participation;
import fr.michot.video.repositories.ParticipationRepository;

@Controller
@RequestMapping("/participation")
public class ParticipationService {
	@Inject
	ParticipationRepository repository;
	
	@RequestMapping(value="acteur/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Participation>  getParticipationsParActeurId(@PathVariable String id) {
		return repository.findByActeurId(id);
	}
	
	@RequestMapping(value="film/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Participation>  getParticipationsParFilmId(@PathVariable String id) {
		return repository.findByFilmId(id);
	}
	
	@RequestMapping(value="id/{id}", method = RequestMethod.GET)
	public @ResponseBody Participation  getParticipationParId(@PathVariable String id) {
		return repository.findOne(id);
	}
	
	@RequestMapping(value="all", method = RequestMethod.GET)
	public @ResponseBody List<Participation>  getAllParticipations() {
		ArrayList<Participation> participations = new ArrayList<Participation>();
		Iterable<Participation> iter = repository.findAll();
		for (Participation participation : iter) {
			participations.add(participation);
		}
		return participations;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Participation setParticipation(@RequestBody Participation Participation) {
		return repository.save(Participation);
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE)
	public @ResponseBody String deleteParticipation(@PathVariable String id) {
		repository.delete(id);
		return id;
	}

}
