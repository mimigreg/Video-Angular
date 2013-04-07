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

import fr.michot.video.beans.Film;
import fr.michot.video.repositories.FilmRepository;

@Controller
@RequestMapping("/film")
public class FilmService {
	@Inject
	FilmRepository repository;
	
	@RequestMapping(value="titre/{titre}", method = RequestMethod.GET)
	public @ResponseBody List<Film>  getFilmsParTitre(@PathVariable String titre) {
		return repository.findByTitre(titre);
	}
	
	@RequestMapping(value="id/{id}", method = RequestMethod.GET)
	public @ResponseBody Film  getFilmParId(@PathVariable String id) {
		return repository.findOne(id);
	}
	
	@RequestMapping(value="all", method = RequestMethod.GET)
	public @ResponseBody List<Film>  getAllFilms() {
		ArrayList<Film> films = new ArrayList<Film>();
		Iterable<Film> iter = repository.findAll();
		for (Film film : iter) {
			films.add(film);
		}
		return films;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Film setFilm(@RequestBody Film Film) {
		return repository.save(Film);
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE)
	public @ResponseBody String deleteFilm(@PathVariable String id) {
		repository.delete(id);
		return id;
	}

}
