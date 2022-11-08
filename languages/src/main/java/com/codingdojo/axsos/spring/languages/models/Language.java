package com.codingdojo.axsos.spring.languages.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="languages")
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Name must not be blank")
	@Size(min = 3, max = 20, message="Name must be at least 3 characters")
	private String name;
	
	@NotNull(message="Creator must not be blank")
	@Size(min = 3, max = 20, message="Creator must be at least 3 characters")
	private String creator;
	
	@NotNull(message="Version must not be blank")
	@Min(value=0, message="Version must be greater than zero")
	private Double version;
	
	
	public Language() {}
	
	public Language(String name, String creator, Double version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Double getVersion() {
		return version;
	}

	public void setVersion(Double version) {
		this.version = version;
	}
}