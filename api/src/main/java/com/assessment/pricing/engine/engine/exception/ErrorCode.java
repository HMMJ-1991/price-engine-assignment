package com.assessment.pricing.engine.engine.exception;

public enum ErrorCode {

	ERROR_DEFAULT(100, "Default Error");
	
	private int code;
	private String description;

	private ErrorCode(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
