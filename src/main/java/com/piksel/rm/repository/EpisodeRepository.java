package com.piksel.rm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piksel.rm.domain.Episode;

/**
 * Spring Data JPA repository for the Episode entity.
 */
public interface EpisodeRepository extends JpaRepository<Episode, String> {

}
