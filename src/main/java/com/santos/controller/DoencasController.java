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

import com.santos.domain.Doencas;
import com.santos.service.DoencasService;

@RestController
@RequestMapping("/doencas")
public class DoencasController {

	@Autowired
	private DoencasService service;

	@GetMapping("/{id")
	public Doencas Doencas(@PathVariable Long id) {
		return service.findById(id);	
	}
	
	@GetMapping
	public List<Doencas> Doencass () {
		return service.all();		
	}
	
	@PostMapping
	public Doencas newDoencas(@RequestBody Doencas entity) {
		return service.save(entity);		
	}
	
	@DeleteMapping
	public void delete (@PathVariable Long id) {
		service.delete(id);		
	}
	
	@PutMapping("/{id}")
	public Doencas update(@PathVariable Long id, @RequestBody Doencas entity) {
		return service.update(id, entity);		
	}
}
