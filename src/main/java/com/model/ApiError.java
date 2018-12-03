package com.model;

import java.io.Serializable;
import java.util.List;

public class ApiError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<String> errors;

	public ApiError() {
		super();
	}

	public ApiError(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
