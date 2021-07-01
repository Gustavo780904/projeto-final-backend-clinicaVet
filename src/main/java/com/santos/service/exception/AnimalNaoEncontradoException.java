package com.santos.service.exception;

public class AnimalNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AnimalNaoEncontradoException(Long id) {
		super("Animal não encontrado: " + id);
	}
}
