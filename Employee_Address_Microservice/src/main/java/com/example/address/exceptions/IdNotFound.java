package com.example.address.exceptions;

public class IdNotFound extends Exception{
	private static final long serialVersionUID = 1L;
	
	public IdNotFound() {
		super();
	}
	
	public IdNotFound(String e) {
		super(e);
	}
}
