package com.service;

import java.io.Serializable;

public class JwtAuthResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String token;

	public JwtAuthResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

}
