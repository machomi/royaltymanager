package com.piksel.rm.web.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.piksel.rm.service.ViewingService;
import com.piksel.rm.service.dto.ViewDTO;
import com.piksel.rm.web.validation.ViewValidator;

public class ViewResourceTest {

	@Mock
	ViewingService viewingService;

	@Mock
	ViewValidator viewValidator;

	private MockMvc restMvc;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
		when(viewValidator.supports(ViewDTO.class)).thenReturn(true);

		ViewResource viewResource = new ViewResource();
		ReflectionTestUtils.setField(viewResource, "viewingService", viewingService);
		ReflectionTestUtils.setField(viewResource, "viewValidator", viewValidator);

		restMvc = MockMvcBuilders.standaloneSetup(viewResource).build();
	}

	@Test
	public void testViewItem() throws Exception {
		restMvc.perform(
				post("/royaltymanager/viewing").content("{\"customer\":\"1234567890\",\"episode\":\"0987654321\" }")
						.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isAccepted());
	}

	@Test
	public void testReset() throws Exception {
		restMvc.perform(post("/royaltymanager/reset").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());
	}

}
