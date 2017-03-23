package com.piksel.rm.service;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.piksel.rm.service.dto.PaymentDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PaymentServiceTest {

	@Autowired
	PaymentService paymentService;

	@Test
	public void testFindAll() {
		List<PaymentDTO> result = paymentService.findAll(new PageRequest(0, 100));
		assertThat(result, Matchers.hasSize(4));
	}

	@Test
	public void testFind() {
		Optional<PaymentDTO> result = paymentService.find("665115721c6f44e49be3bd3e26606026");
		assertTrue(result.isPresent());
	}

}
