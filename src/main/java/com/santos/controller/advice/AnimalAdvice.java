package com.santos.controller.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.santos.service.exception.AnamneseNaoEncontradaException;
import com.santos.service.exception.AnimalNaoEncontradoException;
import com.santos.service.exception.ConsultaNaoEncontradaException;
import com.santos.service.exception.DoencaNaoEncontradaException;
import com.santos.service.exception.ExameNaoEncontradoException;


@ControllerAdvice
public class AnimalAdvice {
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
	@ResponseBody
	@ExceptionHandler(AnimalNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String campoVazio(AnimalNaoEncontradoException ex) {
		return ex.getLocalizedMessage();
	}
	@ResponseBody
	@ExceptionHandler(AnamneseNaoEncontradaException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String campoVazio(AnamneseNaoEncontradaException ex) {
		return ex.getLocalizedMessage();
	}
	@ResponseBody
	@ExceptionHandler(ConsultaNaoEncontradaException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String campoVazio(ConsultaNaoEncontradaException ex) {
		return ex.getLocalizedMessage();
	}
	@ResponseBody
	@ExceptionHandler(DoencaNaoEncontradaException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String campoVazio(DoencaNaoEncontradaException ex) {
		return ex.getLocalizedMessage();
	}
	@ResponseBody
	@ExceptionHandler(ExameNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String campoVazio(ExameNaoEncontradoException ex) {
		return ex.getLocalizedMessage();
	}
}
