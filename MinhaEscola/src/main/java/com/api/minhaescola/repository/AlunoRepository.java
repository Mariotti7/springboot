package com.api.minhaescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.minhaescola.model.AlunoModel;

public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {


}
