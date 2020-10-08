package com.api.minhaloja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.minhaloja.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
