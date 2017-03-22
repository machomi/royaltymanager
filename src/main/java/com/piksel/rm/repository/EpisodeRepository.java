package com.piksel.rm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piksel.rm.domain.Episode;

/**
 * Spring Data JPA repository for the Episode entity.
 */
public interface EpisodeRepository extends JpaRepository<Episode, String> {

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Episode e SET e.viewsCounter = 0")
	public Integer reset();

	@Modifying
	@Query("UPDATE Episode e SET e.viewsCounter = e.viewsCounter + 1 WHERE e.id = :id")
	public void incrementViews(@Param("id") String id);

}
