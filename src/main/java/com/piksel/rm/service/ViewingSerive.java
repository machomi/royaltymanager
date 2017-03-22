package com.piksel.rm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import com.piksel.rm.repository.EpisodeRepository;
import com.piksel.rm.service.dto.ViewItemDTO;

public class ViewingSerive {

	@Autowired
	private EpisodeRepository episodeRepository;

	@Async
	@Transactional
	public void viewItem(ViewItemDTO viewDto) {

	}

	@Async
	public void reset() {

	}

}
