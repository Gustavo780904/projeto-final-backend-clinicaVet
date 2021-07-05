package com.santos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santos.domain.Animal;
import com.santos.repository.AnimalRepository;
import com.santos.service.exception.AnimalNaoEncontradoException;

@Service
public class AnimalSevice {

	@Autowired
	private AnimalRepository repository;

	public Animal findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new AnimalNaoEncontradoException(id));
	}

	public List<Animal> all() {
		return repository.findAll();
	}

	public Animal save(Animal entity) {
		return repository.save(entity);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Animal update(Long id, Animal entity) {
		entity.setId(id);
		return repository.save(entity);
	}
	//metodos de pesquisa
	public Optional<Animal> listaDadosAnimais(Long id){
		return repository.findById(id);
	}
	

	public List<Object[]> listaNomesAnimais(){
		return repository.listaNomesAnimais();
	}

	public List<Object[]> listaNomesFotosAnimais(){
		return repository.listaNomesFotosAnimais();
	}

	public List<Object[]> listaAnimaisAtivos(){
		return repository.listaAnimaisAtivos();
	}
}
