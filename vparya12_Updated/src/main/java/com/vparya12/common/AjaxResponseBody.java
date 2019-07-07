package com.vparya12.common;

import java.util.List;

public class AjaxResponseBody {
	//alter TABLE dth add CONSTRAINT FK_Cust_Id FOREIGN KEY MOBILENUMBER REFERENCES mobile(MOBILENUMBER);
	private String statusMessage;
	private String statusCode;
	private List resultList;
	private Object resultObject;
	private String data;
	private String userName;
	private boolean session;
	
	public List getResultList() {
		return resultList;
	}
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
	public Object getResultObject() {
		return resultObject;
	}
	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public void setSuccess() {
		this.statusCode="200";
		this.statusMessage="SUCCESS";
	}
	public void setFailure() {
		this.statusCode="403";
		this.statusMessage="ERROR";
	}
	public boolean isSession() {
		return session;
	}
	public void setSession(boolean session) {
		this.session = session;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
