package com.carros.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carros.domain.Carro;
import com.carros.domain.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
	
	//instanciar a classe de carros Service para que retorne a lista de carros no endpoint
	@Autowired
	private CarroService service;
	
	@GetMapping()
	public Iterable<Carro> get() {
		return service.getCarros();
	}
	
	
//	@PostMapping("/login")
//	public String login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
//		return "Login " + login + ", senha: " + senha;
//	}
//	
//	@PostMapping("/carros")
//		public String postCarros(@RequestParam("tipo") String tipo, @RequestParam("modelo") String modelo) {
//			return "Tipo do carro: " + tipo + "/" + " modelo: " + modelo;
//		}
//	
//	@GetMapping("/carros/id/{id}")
//	public String getCarById(@PathVariable("id") Long id) {
//		return "Carro ID " + id;
//	}
//	
//	@GetMapping("/carros/tipo/{tipo}")
//	public String GetCarByType(@PathVariable("tipo") String tipo) {
//		return "Carro TIPO " + tipo;
//	}
//	
//	@PostMapping()
//	public String post() {
//		return "Post Hello Spring World!";
//	}
//	
//	@PutMapping()
//	public String put() {
//		return "Put Hello Spring World!";
//	}
//	
//	@DeleteMapping()
//	public String delete() {
//		return "Delete Hello Spring World!";
//	}
	
}
