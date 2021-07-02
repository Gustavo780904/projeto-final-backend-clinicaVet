package com.santos.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Consulta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codConsulta;
	private String dataConsulta;
	private String observacoes;
	private String queixas;
	private String historico;
	
	@OneToOne
	private Anamnese anamnese;
	
	@ManyToOne
	@JsonBackReference
	private Animal animalConsulta;
	
}
