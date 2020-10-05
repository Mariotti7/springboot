package com.api.minhaescola.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.minhaescola.model.AlunoModel;
import com.api.minhaescola.repository.AlunoRepository;

@RestController
@RequestMapping("/")
public class AlunoController<Aluno> {
	
	@Autowired
	public AlunoRepository repository;
	
	@GetMapping("/alunos")
	public @ResponseBody List<AlunoModel> encontrar(){
		return repository.findAll();
	}
	
	@GetMapping("/alunos/{id}")
	public Optional<AlunoModel> getById(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@PostMapping("/alunos")
	public @ResponseBody AlunoModel cadastrar(@RequestBody AlunoModel aluno) {
		return repository.save(aluno);
	}
	
	@PutMapping("/aluno/{id}")
	public ResponseEntity<AlunoModel> alterar(@PathVariable Long id, @RequestBody AlunoModel cadastro) {
		cadastro.setId_aluno(id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cadastro));
	}

	@DeleteMapping("/id/{id}")
	public void Delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
