package com.piksel.rm.service.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViewDTO {

	@ApiModelProperty("Episode identifier")
	@NotNull
	private String episode;

	@ApiModelProperty("Customer identifier")
	@NotNull
	private String customer;

}
