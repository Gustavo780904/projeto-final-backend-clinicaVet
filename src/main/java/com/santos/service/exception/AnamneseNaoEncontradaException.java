package com.santos.service.exception;

public class AnamneseNaoEncontradaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AnamneseNaoEncontradaException(Long id) {
		super("Anamnse não encontrada: " + id);
	}
}