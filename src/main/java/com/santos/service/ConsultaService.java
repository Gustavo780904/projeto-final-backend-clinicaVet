package com.santos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.domain.Anamnese;
import com.santos.domain.Consulta;
import com.santos.repository.AnamneseRepository;
import com.santos.repository.ConsultaRepository;
import com.santos.service.exception.ConsultaNaoEncontradaException;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;
	private AnamneseRepository anamneserepository;

	public Consulta findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ConsultaNaoEncontradaException(id));
	}

	public List<Consulta> all() {
		return repository.findAll();
	}

	public Consulta save(Consulta entity) {
		return repository.save(entity);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Consulta update(Long id, Consulta entity){
		entity.setCodConsulta(id);
		return repository.save(entity);
	}

	public Consulta saveConsultaComAnamnese(Consulta entity, Long id) {
		Anamnese anamnese = anamneserepository.getById(id);
		entity.setAnamnese(anamnese);
		return repository.save(entity);
	}
}
