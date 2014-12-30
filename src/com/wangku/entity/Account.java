package com.wangku.entity;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = -7970848646314840509L;

	private Long id;
	private String name;

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
