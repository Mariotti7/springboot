package com.api.blogpessoal.controller;

import java.util.List;

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

import com.api.blogpessoal.model.ModelBlog;
import com.api.blogpessoal.repository.BlogRepository;

@RestController
@RequestMapping("/")
public class ControllerBlog {

	@Autowired
	private BlogRepository acao;

	@GetMapping("/blogpessoal")
	public @ResponseBody List<ModelBlog> list() {
		return acao.findAll();
	}

	@GetMapping("/{id}")
	public List<ModelBlog> GetById(@PathVariable long id) {
		return acao.findById(id);
	}

	@PostMapping("/blogpessoal")
	public @ResponseBody ModelBlog insert(@RequestBody ModelBlog profile) {
		return acao.save(profile);
	}

	@PutMapping("/blogpessoal/{id}")
	public ResponseEntity<ModelBlog> update(@PathVariable Long id, @RequestBody ModelBlog content) {
		content.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(acao.save(content));
	}

	@DeleteMapping("/{id}")
	public void Delete(@PathVariable long id) {
		acao.deleteById(id);
	}
	
	@GetMapping("/content/{content}")
	public ResponseEntity<List<ModelBlog>> GetByTitulo(@PathVariable String content){
		return ResponseEntity.ok(acao.findAllByTituloContainingIgnoreCase(content));
	}

}
