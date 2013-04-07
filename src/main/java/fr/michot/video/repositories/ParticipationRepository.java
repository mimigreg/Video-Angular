package fr.michot.video.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import fr.michot.video.beans.Participation;

public interface ParticipationRepository extends PagingAndSortingRepository<Participation, String> {
	
	//@Query("{ 'acteur._id' : { '$oid' : ?0 }}") // Pas de DBRef
	@Query("{ 'acteur.$id' :  { '$oid' : ?0 } }") // Avec DBRef
	List<Participation> findByActeurId(String id);

	//@Query("{ 'film._id' : { '$oid' : ?0 }}") // Pas de DBRef
	@Query("{ 'film.$id' : { '$oid' : ?0 } }") // Avec DBRef
	List<Participation> findByFilmId(String id);
}
