package com.santos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String foto;
	private String raca;
	private String pelagem;
	private int peso;
	private int tipo;
	private String dataNascimento;
	private String data_cadastro;
	private int estado;
	
	@OneToMany(mappedBy = "animalExame")
	@JsonManagedReference
	private List <Exame> exames = new ArrayList<Exame>();
	@OneToMany(mappedBy = "animalConsulta")
	@JsonManagedReference
	private List <Consulta> consultas = new ArrayList<Consulta>();
	

}
