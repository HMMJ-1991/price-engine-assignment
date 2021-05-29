package com.assessment.pricing.engine.engine.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@JsonPropertyOrder({ "statusCode", "message", "data" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "Details About the Response")
public class ApiResponse<T> {

	@ApiModelProperty(notes = "Response status code")
	private int statusCode;

	@ApiModelProperty(notes = "Response message")
	private String message;

	@JsonInclude(content = Include.ALWAYS)
	@ApiModelProperty(notes = "Response data")
	private T data;


	@SuppressWarnings("unchecked")
	private ApiResponse(ApiResponseBuilder builder) {
		this.statusCode = builder.statusCode;
		this.message = builder.message;
		this.data = (T) builder.data;
	}

	protected ApiResponse() {}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}


	public static class ApiResponseBuilder<T> {

		private int statusCode = HttpStatus.OK.value();
		private String message = "";
		private T data;

		public ApiResponseBuilder<T> withData(T data) {
			this.data = data;
			return this;
		}

		public ApiResponseBuilder<T> withMessage(String message) {
			this.message = message;
			return this;
		}

		public ApiResponseBuilder<T> withHttpStatus(HttpStatus httpStatus) {
			this.message = httpStatus.getReasonPhrase();
			this.statusCode = httpStatus.value();
			return this;
		}

		public ResponseEntity<ApiResponse> build() {
			ApiResponse<T> apiResponse = new ApiResponse<>(this);
			if (apiResponse.statusCode == HttpStatus.OK.value()) {
				return ResponseEntity.ok(apiResponse);
			}
			return ResponseEntity.status(HttpStatus.valueOf(this.statusCode)).body(apiResponse);
		}
	}	
}
