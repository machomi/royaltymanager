package com.piksel.rm.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

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

	@CreatedDate
	private Date createdAt;

}
