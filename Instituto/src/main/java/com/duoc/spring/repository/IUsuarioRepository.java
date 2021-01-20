package com.duoc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.spring.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByUsername(String username);
}
