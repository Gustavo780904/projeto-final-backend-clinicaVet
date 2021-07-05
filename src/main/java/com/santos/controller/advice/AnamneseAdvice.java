package com.santos.controller.advice;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.santos.service.exception.DoencaJaAdicinadaException;
import com.santos.service.exception.LimiteDoecasException;

@ControllerAdvice
public class AnamneseAdvice {
	@ResponseBody
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String anamneseNaoEncontrado(EntityNotFoundException ex) {
		return ex.getMessage();
	}
	@ResponseBody
	@ExceptionHandler(DoencaJaAdicinadaException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String doencaJaAdicionada(DoencaJaAdicinadaException ex) {
		return ex.getMessage();
	}
	@ResponseBody
	@ExceptionHandler(LimiteDoecasException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String limiteDoencasAlcancado(LimiteDoecasException ex) {
		return ex.getMessage();
	}
}
