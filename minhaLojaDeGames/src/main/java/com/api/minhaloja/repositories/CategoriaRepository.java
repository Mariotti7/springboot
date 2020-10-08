package com.api.minhaloja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.minhaloja.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

}
