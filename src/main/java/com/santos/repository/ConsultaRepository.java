package com.santos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santos.domain.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}