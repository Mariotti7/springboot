package com.meli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meli.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

	List<Marca> findAllByNomeMarcaContainingIgnoreCase(Marca nomeMarca);

}
