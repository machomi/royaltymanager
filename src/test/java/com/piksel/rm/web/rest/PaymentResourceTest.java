package com.piksel.rm.web.rest;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.piksel.rm.service.PaymentService;
import com.piksel.rm.service.dto.PaymentDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentResourceTest {

	@Mock
	private PaymentService paymentService;

	private MockMvc restMvc;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		when(paymentService.find(anyString())).thenReturn(Optional.empty());
		when(paymentService.find("665115721c6f44e49be3bd3e26606026"))
				.thenReturn(Optional.of(new PaymentDTO("rightsownerId", "rightsowner", 12.0, 5l)));

		PaymentResource paymentResource = new PaymentResource();
		ReflectionTestUtils.setField(paymentResource, "paymentService", paymentService);

		restMvc = MockMvcBuilders.standaloneSetup(paymentResource)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver()).build();
	}

	@Test
	public void testGetPayments() throws Exception {
		restMvc.perform(get("/royaltymanager/payments").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void testGetPayment() throws Exception {
		restMvc.perform(
				get("/royaltymanager/payments/665115721c6f44e49be3bd3e26606026").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetPaymentNotFound() throws Exception {
		restMvc.perform(get("/royaltymanager/payments/nonExistingStudio").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

}
