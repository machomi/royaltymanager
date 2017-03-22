package com.piksel.rm.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piksel.rm.service.dto.ViewDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "views")
public class View {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	@JsonIgnore
	private Episode episode;

	@NotNull
	private String customer;

	@NotNull
	private LocalDateTime createdAt;

	public View(ViewDTO viewDTO) {
		this.episode = new Episode(viewDTO.getEpisode());
		this.customer = viewDTO.getCustomer();
		this.createdAt = LocalDateTime.now();
	}
}
