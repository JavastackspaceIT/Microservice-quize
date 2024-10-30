package com.javastackspace.it.questionservice.bean;

public class Error {

	private String errorCode;
	private String errodDescription;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrodDescription() {
		return errodDescription;
	}

	public void setErrodDescription(String errodDescription) {
		this.errodDescription = errodDescription;
	}

	public Error(String errorCode, String errodDescription) {
		this.errorCode = errorCode;
		this.errodDescription = errodDescription;
	}
	
	

}
