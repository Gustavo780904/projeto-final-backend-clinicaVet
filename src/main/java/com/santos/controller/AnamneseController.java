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

import com.santos.domain.Anamnese;
import com.santos.service.AnamneseService;

@RestController
@RequestMapping("/anamnese")
public class AnamneseController {

	@Autowired
	private AnamneseService service;

	@GetMapping("/{id}")
	public Anamnese Anamnese(@PathVariable Long id) {
		return service.findById(id);	
	}
	
	@GetMapping
	public List<Anamnese> Anamneses () {
		return service.all();		
	}
	
	@PostMapping
	public Anamnese newAnamnese(@RequestBody Anamnese entity) {
		return service.save(entity);		
	}
	
	@DeleteMapping
	public void delete (@PathVariable Long id) {
		service.delete(id);		
	}
	
	@PutMapping("/{id}")
	public Anamnese update(@PathVariable Long id, @RequestBody Anamnese entity) {
		return service.update(id, entity);		
	}
	
}
