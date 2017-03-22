package com.piksel.rm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An Episode.
 */
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "id")
@NoArgsConstructor
@Entity
@Data
@Table(name = "episodes")
public class Episode implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "name")
	private String name;

	// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
	// property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(optional = false)
	@NotNull
	@JoinColumn(name = "rightsowner")
	private Studio rightsowner;

	@Min(0)
	@NotNull
	private Long viewsCounter = 0l;

	public Episode(String id) {
		this.id = id;
	}

}
