package com.santos.service.exception;

public class LimiteDoecasException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LimiteDoecasException() {
		super("Não é possível adicionar mais doenças.");
	}

}
