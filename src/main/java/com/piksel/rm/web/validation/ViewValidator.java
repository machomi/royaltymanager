package com.piksel.rm.web.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.piksel.rm.repository.EpisodeRepository;
import com.piksel.rm.service.dto.ViewDTO;

@Component
public class ViewValidator implements Validator {

	@Autowired
	EpisodeRepository episodeRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return ViewDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "episode", "field.required", "Episode is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer", "field.required", "Customer is requied");

		ViewDTO viewDTO = (ViewDTO) target;
		if (!episodeRepository.exists(viewDTO.getEpisode())) {
			errors.rejectValue("episode", "episode.notExists",
					String.format("Provided %s episode does not exist.", viewDTO.getEpisode()));
		}

	}

}
