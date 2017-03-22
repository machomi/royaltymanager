package com.piksel.rm.web.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.piksel.rm.service.ViewingService;
import com.piksel.rm.service.dto.ViewDTO;
import com.piksel.rm.web.validation.ViewValidator;

@RestController
public class ViewResource {

	@Autowired
	ViewValidator viewValidator;

	@Autowired
	ViewingService viewingService;

	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
		if (binder.getTarget() instanceof ViewDTO) {
			binder.addValidators(viewValidator);
		}
	}

	@PostMapping("/royaltymanager/viewing")
	public ResponseEntity<?> viewItem(@Valid @RequestBody ViewDTO view) {
		viewingService.viewItem(view);
		return ResponseEntity.accepted().build();
	}

	@PostMapping("/royaltymanager/reset")
	public ResponseEntity<?> reset() {
		viewingService.reset();
		return ResponseEntity.accepted().build();
	}

}
