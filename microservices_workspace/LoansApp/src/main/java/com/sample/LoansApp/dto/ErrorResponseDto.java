package com.sample.LoansApp.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

//import lombok.Data;

public class ErrorResponseDto {
	
	private String apiPath;
	private HttpStatus errCode;
	private String errMessage;
	private LocalDateTime errTime;
	
	public ErrorResponseDto() {}

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	public HttpStatus getErrCode() {
		return errCode;
	}

	public void setErrCode(HttpStatus errCode) {
		this.errCode = errCode;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public LocalDateTime getErrTime() {
		return errTime;
	}

	public void setErrTime(LocalDateTime errTime) {
		this.errTime = errTime;
	}

	@Override
	public String toString() {
		return "Error Response [apiPath=" + apiPath + ", errCode=" + errCode + ", errMessage=" + errMessage
				+ ", errTime=" + errTime + "]";
	}

	public ErrorResponseDto(String apiPath, HttpStatus errCode, String errMessage, LocalDateTime errTime) {
		this.apiPath = apiPath;
		this.errCode = errCode;
		this.errMessage = errMessage;
		this.errTime = errTime;
	}
	
	
}
