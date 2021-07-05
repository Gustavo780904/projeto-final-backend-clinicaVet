package com.santos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.santos.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
	
	// consulta dos dados de um animal.
	
	@Query(value = "select foto, nome, raca, tipo, peso from animal where id = ?1;", nativeQuery = true)
	List<Animal[]> listaDadosAnimais(Long id);

	// lista todos os nomes dos animais a serem consultados
	@Query(value = "select nome from animal;", nativeQuery = true)
	List<Object[]> listaNomesAnimais();

	// lista todos os nomes e fotos dos animais a serem consultados
	
	@Query(value = "select nome, foto from animal;", nativeQuery = true)
	List<Object[]> listaNomesFotosAnimais();
	
	// lista ativos
	@Query(value = "select foto, nome, raca, tipo, peso from animal where estado = 1;", 
			nativeQuery = true)
	List<Object[]> listaAnimaisAtivos();

}