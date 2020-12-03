package com.meli.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String estadoProduto;

	private String tipoAvaria;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	protected Produto() {
	}

	protected Produto(Long id, String nome, String estadoProduto, String tipoAvaria) {
		this.id = id;
		this.nome = nome;
		this.estadoProduto = estadoProduto;
		this.tipoAvaria = tipoAvaria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstadoProduto() {
		return estadoProduto;
	}

	public void setEstadoProduto(String estadoProduto) {
		this.estadoProduto = estadoProduto;
	}

	public String getTipoAvaria() {
		return tipoAvaria;
	}

	public void setTipoAvaria(String tipoAvaria) {
		this.tipoAvaria = tipoAvaria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
