package com.santos.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santos.domain.Animal;
import com.santos.service.AnimalSevice;

@RestController
@RequestMapping("/animal")
public class AnimalController {

	@Autowired
	private AnimalSevice service;

	@GetMapping("/{id}")
	public Animal animal(@Valid @PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Animal> animais() {
		return service.all();
	}

	@PostMapping
	public Animal newAnimal(@Valid @RequestBody Animal entity) {
		return service.save(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@Valid @PathVariable Long id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public Animal update(@Valid @PathVariable Long id, @Valid @RequestBody Animal entity) {
		return service.update(id, entity);
	}

	@GetMapping("/dadosanimais/{id}")
	public List<Animal[]> listaDadosAnimais(@Valid @PathVariable Long id) {
		return service.listaDadosAnimais(id);
	}

	@GetMapping("/nomeanimais")
	public List<Object[]> listaNomesAnimais() {
		return service.listaNomesAnimais();
	}

	@GetMapping("/nomesfotosanimais")
	public List<Object[]> listaNomesFotosAnimais() {
		return service.listaNomesFotosAnimais();
	}

	@GetMapping("/animaisativos")
	public List<Object[]> listaAnimaisAtivos() {
		return service.listaAnimaisAtivos();
	}

}
