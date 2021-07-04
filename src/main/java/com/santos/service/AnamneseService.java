package com.santos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.domain.Anamnese;
import com.santos.repository.AnamneseRepository;
import com.santos.service.exception.AnamneseNaoEncontradaException;

@Service
public class AnamneseService {

	@Autowired
	private AnamneseRepository repository;
//	@Autowired
//	private DoencasRepository doencaRepository;

	public Anamnese findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new AnamneseNaoEncontradaException(id));
	}

	public List<Anamnese> all() {
		return repository.findAll();
	}

	public Anamnese save(Anamnese entity) {
		return repository.save(entity);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Anamnese update(Long id, Anamnese entity) {
		entity.setCodAnamnese(id);
		return repository.save(entity);
	}
	
//	public Anamnese newAnamneseComDoenca (List<Long> id, Anamnese entity, Doencas[] doencas) {
//		doencas
//		id.stream().forEach(id ->   doencaRepository.getById(id));
//		;
//		entity.setDoencas(doenca);;
//		return entity;
//	}

}
