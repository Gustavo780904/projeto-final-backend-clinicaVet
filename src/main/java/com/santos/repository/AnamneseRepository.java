package com.santos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santos.domain.Anamnese;

public interface AnamneseRepository extends JpaRepository<Anamnese, Long> {

}