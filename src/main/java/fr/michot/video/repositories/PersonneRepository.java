package fr.michot.video.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.michot.video.beans.Personne;

public interface PersonneRepository extends PagingAndSortingRepository<Personne, String> {
	List<Personne> findByNom(String nom);
}
