package com.api.minhaloja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.minhaloja.model.UsuarioModel;
import com.api.minhaloja.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	public UsuarioRepository repository;
	
	//trazer todos os usuarios
	@GetMapping
	public ResponseEntity<List<UsuarioModel>>findAllUsuario(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//trazer um unico usuario por id
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<UsuarioModel>> findByIDUsuario(@PathVariable Long id){
		return ResponseEntity.ok(repository.findById(id));
	}
	
	//gravar um novo usuario no banco de dados
	@PostMapping
	public ResponseEntity<UsuarioModel>postUsuario(@RequestBody UsuarioModel usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	//atualizar dados do usuario
	@PutMapping
	public ResponseEntity<UsuarioModel>putUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuario){
			usuario.setId(id);
			return ResponseEntity.ok(repository.save(usuario));
	}
	
	//apagar um usuario do banco de dados
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
	
	
}
