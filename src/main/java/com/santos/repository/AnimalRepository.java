package com.santos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santos.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{

}