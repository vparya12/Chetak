package com.vparya12.common;

public class TrackerException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String properMsg;
	
	public TrackerException(String properMsg,String error) {
		this.properMsg=properMsg;
		this.errorMessage=error;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getProperMsg() {
		return properMsg;
	}

	public void setProperMsg(String properMsg) {
		this.properMsg = properMsg;
	}

	
}
