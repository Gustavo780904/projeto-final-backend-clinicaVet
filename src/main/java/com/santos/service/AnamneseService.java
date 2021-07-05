package com.santos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.domain.Anamnese;
import com.santos.domain.Doencas;
import com.santos.repository.AnamneseRepository;
import com.santos.service.exception.AnamneseNaoEncontradaException;
import com.santos.service.exception.DoencaJaAdicinadaException;
import com.santos.service.exception.LimiteDoecasException;

@Service
public class AnamneseService {

	@Autowired
	private AnamneseRepository repository;

	@Autowired
	private DoencasService doencaService;

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
	
	public Anamnese addDoencaAnamnese (Long idAnamnese, Long idDoencas) {
	Anamnese anamnese = repository.findById(idAnamnese).orElseThrow(() -> new AnamneseNaoEncontradaException(idAnamnese));
	Doencas doenca = doencaService.findById(idDoencas);
	if(anamnese.getDoencas().contains(doenca)) {
		throw new DoencaJaAdicinadaException(idDoencas);
	}
	if(anamnese.getDoencas().size()>=5) {
		throw new LimiteDoecasException();
	}
	anamnese.getDoencas().add(doenca);
	return update(idAnamnese, anamnese);
	}

}
