package com.santos.service.exception;

public class ConsultaNaoEncontradaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ConsultaNaoEncontradaException(Long id) {
		super("Consulta não encontrada: " + id);
	}
}