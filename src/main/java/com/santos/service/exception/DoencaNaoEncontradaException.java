package com.santos.service.exception;

public class DoencaNaoEncontradaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DoencaNaoEncontradaException(Long id) {
		super("Doença não encontrada: " + id);
	}
}