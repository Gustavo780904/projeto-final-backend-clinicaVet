package com.santos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.domain.Animal;
import com.santos.domain.Exame;
import com.santos.repository.AnimalRepository;
import com.santos.repository.ExameRepository;
import com.santos.service.exception.ExameNaoEncontradoException;

@Service
public class ExameService {

	@Autowired
	private ExameRepository repository;
	
	@Autowired
	private AnimalRepository animalRepository;

	public Exame findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ExameNaoEncontradoException(id));
	}

	public List<Exame> all() {
		return repository.findAll();
	}

	public Exame save(Exame entity) {
		return repository.save(entity);
	}

	public void delete (Long id) {
		repository.deleteById(id);
	}

	public Exame update(Long id, Exame entity) {
		entity.setCod_exame(id);
		return repository.save(entity);
	}

	public Exame novoexame(Long id, Exame entity) {
		Animal animal = animalRepository.getById(id);
		entity.setAnimalExame(animal);
		return null;
	}

}
