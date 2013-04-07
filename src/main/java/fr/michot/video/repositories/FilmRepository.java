package fr.michot.video.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.michot.video.beans.Film;

public interface FilmRepository extends PagingAndSortingRepository<Film, String> {
	List<Film> findByTitre(String titre);
}
