package com.meli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meli.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);

}
