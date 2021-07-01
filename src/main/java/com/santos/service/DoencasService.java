package com.santos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.domain.Doencas;
import com.santos.repository.DoencasRepository;
import com.santos.service.exception.DoencaNaoEncontradaException;

@Service
public class DoencasService {

	@Autowired
	private DoencasRepository repository;

	public Doencas findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new DoencaNaoEncontradaException(id));
	}

	public List<Doencas> all() {
		return repository.findAll();
	}

	public Doencas save(Doencas entity) {
		return repository.save(entity);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Doencas update(Long id, Doencas entity){
		entity.setCod_doenca(id);
		return repository.save(entity);
	}
}
