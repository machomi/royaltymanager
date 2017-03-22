package com.piksel.rm.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

	public static final String DEFAULT_INCLUDE_PATTERN = "/royaltymanager/.*";

	/**
	 * Swagger Springfox configuration.
	 *
	 * @return the Swagger Springfox configuration
	 */
	@Bean
	public Docket swaggerSpringfoxDocket() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true)
				.genericModelSubstitutes(ResponseEntity.class).ignoredParameterTypes(java.sql.Date.class)
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class).select()
				.paths(regex(DEFAULT_INCLUDE_PATTERN)).build();
		return docket;
	}
}
