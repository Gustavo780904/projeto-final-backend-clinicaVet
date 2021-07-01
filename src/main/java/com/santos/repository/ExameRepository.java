package com.santos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santos.domain.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {

}