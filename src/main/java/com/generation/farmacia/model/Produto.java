package com.generation.farmacia.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity                		// Entidade para gerar tabela no BD.
@Table(name = "tb_produtos")

public class Produto {
	
	@Id	// PK	// @GeneratedValue = PK sera gerada automaticamente.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY = auto-increment.
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório!")                                       										
	private String nome;
	
	@NotBlank(message = "Descrição é obrigatório!") 
	@Size(max=500, message = "Limite de 500 caracteres!") 
	private String descricao;
	
	private int quantidade;
	
	private String laboratorio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING) // formatar o valor do preço do produto como uma String.
	@NotNull(message="Preço é obrigatório!")
	@Positive(message = "Digite um valor maior do que zero.")
	private BigDecimal preco;
	
	private String foto;
	
	@ManyToOne // Relacionamento "produto" muitos para um com a Classe Categoria.
	@JsonIgnoreProperties("produto") // Quebra recursividade infinita durante exibicao JSON.
	private Categoria categoria;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
