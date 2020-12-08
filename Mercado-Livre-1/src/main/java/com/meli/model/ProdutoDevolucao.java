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
public class ProdutoDevolucao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProdutoDevolucao;

	private String nomeProdutoDevolucao;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("prodDevolucao")
	private Categoria categoriaProd;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("produtoDev")
	private Marca marca;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("produtoDevolucao")
	private Motivo motivo;

	private String codigoDevolucao;

	protected ProdutoDevolucao() {
	}

	protected ProdutoDevolucao(Long idProdutoDevolucao, String nomeProdutoDevolucao, Motivo motivo) {
		this.idProdutoDevolucao = idProdutoDevolucao;
		this.nomeProdutoDevolucao = nomeProdutoDevolucao;
		this.motivo = motivo;
	}

	public Long getIdProdutoDevolucao() {
		return idProdutoDevolucao;
	}

	public void setIdProdutoDevolucao(Long idProdutoDevolucao) {
		this.idProdutoDevolucao = idProdutoDevolucao;
	}

	public String getNomeProdutoDevolucao() {
		return nomeProdutoDevolucao;
	}

	public void setNomeProdutoDevolucao(String nomeProdutoDevolucao) {
		this.nomeProdutoDevolucao = nomeProdutoDevolucao;
	}

	public Categoria getCategoriaProd() {
		return categoriaProd;
	}

	public void setCategoriaProd(Categoria categoriaProd) {
		this.categoriaProd = categoriaProd;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public String getCodigoDevolucao() {
		return codigoDevolucao;
	}

	public void setCodigoDevolucao(String codigoDevolucao) {
		this.codigoDevolucao = codigoDevolucao;
	}

}
