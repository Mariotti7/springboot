package com.api.minhaloja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.minhaloja.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long>{

}
