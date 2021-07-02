package com.santos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.domain.Anamnese;
import com.santos.domain.Consulta;
import com.santos.repository.AnamneseRepository;
import com.santos.repository.ConsultaRepository;
import com.santos.service.exception.AnamneseNaoEncontradaException;

@Service
public class AnamneseService {

	@Autowired
	private AnamneseRepository repository;
	@Autowired
	private ConsultaRepository consultaRepository;
	

	public Anamnese findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new AnamneseNaoEncontradaException(id));
	}

	public List<Anamnese> all() {
		return repository.findAll();
	}

	public Anamnese save(Anamnese entity) {
		entity = repository.save(entity);
//		consulta = consultaRepository.findById(codConsulta);
//		codAnamnese = entity.getId();
//		consulta.setAnamnese(codAnamnese);
		return entity;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Anamnese update(Long id, Anamnese entity){
		entity.setCodAnamnese(id);
		return repository.save(entity);
	}
	
	
}
