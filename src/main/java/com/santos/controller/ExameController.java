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

import com.santos.domain.Exame;
import com.santos.service.ExameService;

@RestController
@RequestMapping("/exame")
public class ExameController {

	@Autowired
	private ExameService service;

	@GetMapping("/{id")
	public Exame exame(@PathVariable Long id) {
		return service.findById(id);	
	}
	
	@GetMapping
	public List<Exame> exames () {
		return service.all();		
	}
	
	@PostMapping
	public Exame newExame(@RequestBody Exame entity) {
		return service.save(entity);		
	}
	
	@DeleteMapping
	public void delete (@PathVariable Long id) {
		service.delete(id);		
	}
	
	@PutMapping("/{id}")
	public Exame update(@PathVariable Long id, @RequestBody Exame entity) {
		return service.update(id, entity);		
	}
}
