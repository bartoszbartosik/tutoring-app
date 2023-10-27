package com.tutoringapp.exception;

public class TutoringAppException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private Integer id;

	public TutoringAppException(String message) {
		super(message);
	}
	
	public TutoringAppException(String message, Integer id) {
		super(message);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
