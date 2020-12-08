package com.meli.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;

	private String siglaCategoria;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	@OneToMany(mappedBy = "categoriaProd", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoriaProd")
	private List<ProdutoDevolucao> prodDevolucao;

	protected Categoria() {
	}

	protected Categoria(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public String getSiglaCategoria() {
		return siglaCategoria;
	}

	public void setSiglaCategoria(String siglaCategoria) {
		this.siglaCategoria = siglaCategoria;
	}

	public List<ProdutoDevolucao> getProdDevolucao() {
		return prodDevolucao;
	}

	public void setProdDevolucao(List<ProdutoDevolucao> prodDevolucao) {
		this.prodDevolucao = prodDevolucao;
	}

}
