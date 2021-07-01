package br.com.zupacademy.gabriel.pedrico.casadocodigo.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Livro {
			
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String titulo;
	
	@NotNull
	@NotBlank
	@Size(max=500)
	private String resumo;
	
	@Lob
	@Column(columnDefinition = "LONGTEXT",nullable=false)
	private String sumario;
	
	
	@Positive
	@Min(20)
	@NotNull
	private BigDecimal preco;
	
	@NotNull
	@Min(100)
	private Integer numeroPaginas;
	
	@NotNull
	@NotBlank
	private String isbn;
	
	@Future
	private LocalDate dataPublicacao;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	private Autor autor;

	public Livro(@NotNull @NotBlank String titulo, @NotNull @NotBlank @Size(max = 500) String resumo, String sumario,
			@Positive @Min(20) @NotNull BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas,
			@NotNull @NotBlank String isbn, @Future LocalDate dataPublicacao, @NotNull Categoria categoria,
			@NotNull Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}
	
	@Deprecated
	public Livro() {
		
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco=" + preco
				+ ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", categoria=" + categoria + ", autor=" + autor + "]";
	}
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Autor getAutor() {
		return autor;
	}
	
	


	
	


	
	
	
}
