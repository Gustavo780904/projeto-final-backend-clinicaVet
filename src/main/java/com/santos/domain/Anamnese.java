package com.santos.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
@Entity
@Data
public class Anamnese{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codAnamnese;
	private String problemaSistemaDigestivo;
	private String problemaSistemaUroGenital;
	private String problemaSistemaCardioRespiratorio;
	private String problemaSistemaNeurologico;
	private String problemaSistemaLocomotor;
	private String problemaPele;
	private String problemaOlhos;
	private String problemaOuvidos;
	
	@ManyToMany
//	@JsonBackReference
	private List<Doencas> doencas = new ArrayList<Doencas>();

	public Long getId() {
		return codAnamnese;
		
	}

}
