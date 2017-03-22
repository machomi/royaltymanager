package com.piksel.rm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class DatabaseConfiguration {

	@Bean
	public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
		Resource studios = new ClassPathResource("data/studios.json");
		Resource episodes = new ClassPathResource("data/episodes.json");

		Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
		factory.setResources(new Resource[] { studios, episodes });
		return factory;
	}

}
