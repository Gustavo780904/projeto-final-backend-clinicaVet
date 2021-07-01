package com.santos.service.exception;

public class ExameNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExameNaoEncontradoException(Long id) {
		super("Exame não encontrado: " + id);
	}
}