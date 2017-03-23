package com.piksel.rm.service.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViewDTO {

	@NotNull
	private String episode;

	@NotNull
	private String customer;

}
