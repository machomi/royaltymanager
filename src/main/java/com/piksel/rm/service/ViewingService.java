package com.piksel.rm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piksel.rm.domain.View;
import com.piksel.rm.repository.EpisodeRepository;
import com.piksel.rm.repository.ViewRepository;
import com.piksel.rm.service.dto.ViewDTO;

@Service
public class ViewingService {

	private final Logger log = LoggerFactory.getLogger(ViewingService.class);

	@Autowired
	private EpisodeRepository episodeRepository;

	@Autowired
	private ViewRepository viewRepository;

	@Async
	@Transactional
	public void viewItem(ViewDTO viewDTO) {
		log.debug("Incrementing view counter for episode: {}", viewDTO.getEpisode());
		episodeRepository.incrementViews(viewDTO.getEpisode());
		viewRepository.save(new View(viewDTO));
	}

	@Async
	@Transactional
	public void reset() {
		log.debug("Reseting all counters");
		int result = episodeRepository.reset();
		log.debug("Updated records {}", result);
	}

}
