package com.universa.beauty.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universa.beauty.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	

	List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

	Optional<Usuario> findByEmail(String userName);

}
