package com.universa.beauty.repositorio;
	
import java.util.List;	

import org.springframework.data.jpa.repository.JpaRepository;

import com.universa.beauty.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	List<Categoria> findAllByCategoriaContainingIgnoreCase(String categoria);

}
