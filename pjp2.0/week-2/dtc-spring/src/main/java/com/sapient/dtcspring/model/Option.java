package com.sapient.dtcspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="options")
public class Option {
	
	private long id;
	private String name;
	private String url;

	public Option() {
		super();
	}

	public Option(String name) {
		this.name = name;
	}

	@Column(name="option_name", nullable=false)
	public String getOptionName() {
		return name;
	}

	public void setOptionName(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
