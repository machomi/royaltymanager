package com.piksel.rm.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.piksel.rm.repository.StudioRepository;
import com.piksel.rm.service.dto.PaymentDTO;

@Service
public class PaymentService {

	Logger log = LoggerFactory.getLogger(PaymentService.class);

	@Autowired
	StudioRepository studioRepository;

	public List<PaymentDTO> findAll(Pageable page) {
		return studioRepository.calculateAllPayments(page);
	}

	public Optional<PaymentDTO> find(String id) {
		log.debug("Request to get Payment : {}", id);
		return studioRepository.calculatePayment(id);
	}

}
