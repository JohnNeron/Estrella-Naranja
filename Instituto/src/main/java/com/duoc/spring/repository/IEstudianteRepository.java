package com.duoc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.spring.model.Estudiante;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {

}
