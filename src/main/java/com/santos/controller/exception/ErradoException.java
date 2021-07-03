package com.santos.controller.exception;

public class ErradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ErradoException(String mensagem) {
		super(mensagem);
	}
}
