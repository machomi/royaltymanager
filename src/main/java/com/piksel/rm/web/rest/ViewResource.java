package com.piksel.rm.web.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piksel.rm.service.ViewingSerive;
import com.piksel.rm.service.dto.ViewItemDTO;

@RestController
public class ViewResource {

	@Autowired
	ViewingSerive viewingService;

	@PostMapping("/royaltymanager/viewing")
	public ResponseEntity<?> viewItem(@Valid ViewItemDTO view) {
		viewingService.viewItem(view);
		return ResponseEntity.accepted().build();
	}

	@PostMapping("/royaltymanager/reset")
	public ResponseEntity<?> reset() {
		viewingService.reset();
		return ResponseEntity.accepted().build();
	}

}
