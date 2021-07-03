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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santos.domain.Consulta;
import com.santos.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaService service;

	@GetMapping("/{id}")
	public Consulta consulta(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Consulta> cosultas() {
		return service.all();
	}

	@PostMapping("/{id}")
	public Consulta newConsulta(@RequestBody Consulta entity, @PathVariable Long id) {
		return service.save(entity, id);
	}
	
	//salva consulta com anamnese identificada pelo id
	@PostMapping ("/{id}/{codAnamnese}")
	public Consulta newConsultaAnamnese(@RequestBody Consulta entity, @RequestParam List<Long>id) {
		return service.saveConsultaComAnamnese(entity, id, id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public Consulta update(@PathVariable Long id, @RequestBody Consulta entity) {
		return service.update(id, entity);
	}
}
