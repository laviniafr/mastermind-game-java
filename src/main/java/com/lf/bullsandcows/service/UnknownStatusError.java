package com.lf.bullsandcows.service;

public class UnknownStatusError extends RuntimeException{

	public UnknownStatusError(String message) {
		super(message);
	}

	public UnknownStatusError(String message, Throwable cause) {
		super(message, cause);
	}
}
