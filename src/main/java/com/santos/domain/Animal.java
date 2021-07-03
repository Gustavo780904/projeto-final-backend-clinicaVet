package com.santos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;
	@NotBlank(message = "O campo foto é obrigatório")
	private String foto;
	@NotBlank(message = "O campo raca é obrigatório")
	private String raca;
	@NotBlank(message = "O campo pelagem é obrigatório")
	private String pelagem;
	@NotNull
	private Integer peso;
	@NotNull
	private Integer tipo;
	@NotBlank(message = "O campo dataNascimento é obrigatório")
	private String dataNascimento;
	@NotBlank(message = "O campo dataCadastro é obrigatório")
	private String dataCadastro;
	@NotNull
	private Integer estado;

	@OneToMany(mappedBy = "animalExame")
	@JsonManagedReference
	private List<Exame> exames = new ArrayList<Exame>();
	@OneToMany(mappedBy = "animalConsulta")
	@JsonManagedReference
	private List<Consulta> consultas = new ArrayList<Consulta>();

}
