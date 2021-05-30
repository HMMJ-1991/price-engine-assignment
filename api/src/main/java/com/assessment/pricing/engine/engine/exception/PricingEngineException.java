package com.assessment.pricing.engine.engine.exception;

public class PricingEngineException extends Exception {

	private final ErrorCode errorCode;

	private final String message;

	private final Object data;
	
	public PricingEngineException(ErrorCode errorCode) {
		this.errorCode = errorCode;
		this.message = errorCode.getDescription();
		this.data = null;
	}

	public PricingEngineException(ErrorCode errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
		this.data = null;
	}

	public PricingEngineException(ErrorCode errorCode, String message, Object data) {
		this.errorCode = errorCode;
		this.message = message;
		this.data = data;
	}

	public PricingEngineException(ErrorCode errorCode, Object data) {
		this.errorCode = errorCode;
		this.message = errorCode.getDescription();
		this.data = data;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}
	
	
}
