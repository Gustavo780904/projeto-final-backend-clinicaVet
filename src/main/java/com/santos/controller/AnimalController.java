package com.santos.controller;

import java.util.List;

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
	public Animal animal(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Animal> animais() {
		return service.all();
	}

	@PostMapping
	public Animal newAnimal(@RequestBody Animal entity) {
		return service.save(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public Animal update(@PathVariable Long id, @RequestBody Animal entity) {
		return service.update(id, entity);
	}
	
	@GetMapping("/dadosanimais")
	public List<Animal> listaDadosAnimais(@PathVariable Long id) {
		return service.listaDadosAnimais(id);
	}
	@GetMapping("/ultimaconsulta")
	public List<Animal> listaDataUltiamConsulta(@PathVariable Long id) {
		return service.listaDataUltiamConsulta(id);
	}
	@GetMapping("/nomeanimais")
	public List<Animal> listaNomesAnimais() {
		return service.listaNomesAnimais();
	}

}
