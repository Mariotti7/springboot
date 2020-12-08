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
public class Motivo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMotivoDevolucao;

	private String descricaoMotivoDevolucao;

	private String siglaMotivoDevolucao;

	@OneToMany(mappedBy = "motivo", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("motivo")
	private List<ProdutoDevolucao> produtoDevolucao;

	protected Motivo() {
	}

	protected Motivo(Long idMotivoDevolucao, String descricaoMotivoDevolucao, String siglaMotivoDevolucao) {
		this.idMotivoDevolucao = idMotivoDevolucao;
		this.descricaoMotivoDevolucao = descricaoMotivoDevolucao;
		this.siglaMotivoDevolucao = siglaMotivoDevolucao;
	}

	public Long getIdMotivoDevolucao() {
		return idMotivoDevolucao;
	}

	public void setIdMotivoDevolucao(Long idMotivoDevolucao) {
		this.idMotivoDevolucao = idMotivoDevolucao;
	}

	public String getDescricaoMotivoDevolucao() {
		return descricaoMotivoDevolucao;
	}

	public void setDescricaoMotivoDevolucao(String descricaoMotivoDevolucao) {
		this.descricaoMotivoDevolucao = descricaoMotivoDevolucao;
	}

	public String getSiglaMotivoDevolucao() {
		return siglaMotivoDevolucao;
	}

	public void setSiglaMotivoDevolucao(String siglaMotivoDevolucao) {
		this.siglaMotivoDevolucao = siglaMotivoDevolucao;
	}

	public List<ProdutoDevolucao> getProdutoDevolucao() {
		return produtoDevolucao;
	}

}
