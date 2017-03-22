package com.piksel.rm.service.dto;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PaymentDTO {

	@JsonView(PaymentView.List.class)
	private String rightsownerId;

	@JsonView(PaymentView.Item.class)
	private String rightsowner;

	@JsonView(PaymentView.Item.class)
	private Double royalty;

	@JsonView(PaymentView.Item.class)
	private Long viewings;

	public PaymentDTO(String rightsownerId, String rightsowner, Double royalty, Long viewings) {
		this.rightsownerId = rightsownerId;
		this.rightsowner = rightsowner;
		this.royalty = royalty * viewings;
		this.viewings = viewings;
	}

}
