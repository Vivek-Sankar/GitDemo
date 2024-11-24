package com.gitdemo.api.exceptions;

import org.springframework.http.HttpStatus;

public class GitExceptions extends RuntimeException{
	private String errorMessage;
	private HttpStatus status;
	
	public GitExceptions(String errorMessage, HttpStatus status) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.status=status;
	}
	@Override
	public String toString() {
		return this.errorMessage+" "+this.status;
	}
}
