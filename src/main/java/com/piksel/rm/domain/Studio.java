package com.piksel.rm.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * A Studio.
 */
@Entity
@Data
@Table(name = "studios")
public class Studio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@NotNull
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@NotNull
	@DecimalMin(value = "0")
	@Column(name = "payment", nullable = false)
	private Double payment;

	@OneToMany(mappedBy = "rightsowner")
	@JsonIgnore
	private Set<Episode> episodes = new HashSet<>();

	public Studio() {

	}

	public Studio(String id) {
		this.id = id;
	}

}
