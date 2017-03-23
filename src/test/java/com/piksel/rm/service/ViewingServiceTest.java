package com.piksel.rm.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.piksel.rm.domain.Episode;
import com.piksel.rm.repository.EpisodeRepository;
import com.piksel.rm.service.dto.ViewDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ViewingServiceTest {

	@Autowired
	ViewingService viewingService;

	@Autowired
	private EpisodeRepository episodeRepository;

	private static final String TEST_EPISODE_ID = "6a1db5d6610a4c048d3df9a6268c68dc";

	@Test
	public void testViewItem() throws Exception {
		Episode episodeBefore = episodeRepository.findOne(TEST_EPISODE_ID);
		viewingService.viewItem(new ViewDTO(TEST_EPISODE_ID, "customerId"));
		// action is done in async mode, wait for a result
		Thread.sleep(500);
		episodeRepository.flush();
		Episode episodeAfter = episodeRepository.findOne(TEST_EPISODE_ID);
		assertThat(episodeAfter.getViewsCounter(), is(equalTo(episodeBefore.getViewsCounter() + 1)));
	}

	@Test
	public void testReset() {
		viewingService.reset();
		// for test purpose we simple iterate if all entitites are reset to 0
		List<Episode> episodes = episodeRepository.findAll();
		for (Episode episode : episodes) {
			assertThat(episode.getViewsCounter(), is(equalTo(0l)));
		}
	}

}
