package fr.michot.video.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.michot.video.beans.Acteur;

public interface ActeurRepository extends PagingAndSortingRepository<Acteur, String> {
	List<Acteur> findByNom(String nom);
}
