package com.meli.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.model.Marca;
import com.meli.repository.MarcaRepository;

@RestController
@RequestMapping("/marca")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MarcaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MarcaRepository rep;
	
	@GetMapping()
	public ResponseEntity <List<Marca>> getAllMarcas(){
		return ResponseEntity.ok(rep.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Marca> getByIdMarca(@PathVariable Long id) {
		return rep.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("{nome}")
	public ResponseEntity<List<Marca>> getByNomeMarca(@PathVariable Marca nomeMarca){
		return ResponseEntity.ok(rep.findAllByNomeMarcaContainingIgnoreCase(nomeMarca));
	}
	
	@PostMapping()
	public ResponseEntity<Marca> postMarca(@RequestBody Marca marca){
		return ResponseEntity.status(HttpStatus.CREATED).body(rep.save(marca));
	}
	
	@PutMapping()
	public ResponseEntity<Marca> putMarca(@RequestBody Marca marca){
		return ResponseEntity.status(HttpStatus.OK).body(rep.save(marca));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		rep.deleteById(id);
	}
}
