package com.santos.service.exception;

public class DoencaJaAdicinadaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DoencaJaAdicinadaException(Long id) {
		super("Esta doença já foi adicionada: " + id);
	}
}
