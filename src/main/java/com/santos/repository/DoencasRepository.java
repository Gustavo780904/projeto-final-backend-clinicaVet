package com.santos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santos.domain.Doencas;

public interface DoencasRepository extends JpaRepository<Doencas, Long> {

}
