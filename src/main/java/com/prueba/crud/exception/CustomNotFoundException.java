package com.prueba.crud.exception;

public class CustomNotFoundException extends RuntimeException{

	public CustomNotFoundException(String msg) {
		super(msg);
	}
}
