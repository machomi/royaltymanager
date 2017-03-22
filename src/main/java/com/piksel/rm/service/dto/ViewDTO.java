package com.piksel.rm.service.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class ViewDTO {

	@NotNull
	private String episode;

	@NotNull
	private String customer;

}
