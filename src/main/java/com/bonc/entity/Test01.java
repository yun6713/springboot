package com.bonc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="test01")
public class Test01 {

	@Id
	@GeneratedValue(generator = "idsSynLogGenerator")    
	@GenericGenerator(name = "idsSynLogGenerator", strategy = "identity")	
	@Column(name="id")
	Long id;

	@Column(name="name")
	String name;

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
	
	
}
