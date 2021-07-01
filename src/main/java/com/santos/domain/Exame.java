package com.santos.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Exame implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod_exame;
	private boolean hemograma;
	private boolean colesterol;
	private boolean fosforo;
	private boolean calcio;
	private boolean glicose;
	private boolean magnesio;
	private boolean ureia;
	private boolean potassio;
	private String ultrassonografia;
	private String radiografia;
	private String data;
	@ManyToOne
	@JsonBackReference
	private Animal animalExame;

}
