package br.com.zupacademy.gabriel.pedrico.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Livro;

public class LivroDetalhesDto {
	
	@NotNull
	@NotBlank
	private String titulo;

	@NotNull
	@NotBlank
	@Size(max = 500)
	private String resumo;

	@Lob
	@Column(columnDefinition = "LONGTEXT", nullable = false)
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
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	
	public LivroDetalhesDto(Optional<Livro> livro) {
		this.titulo = livro.get().getTitulo();
		this.resumo = livro.get().getResumo();
		this.sumario = livro.get().getSumario();
		this.preco = livro.get().getPreco();
		this.numeroPaginas = livro.get().getNumeroPaginas();
		this.isbn = livro.get().getIsbn();
		this.dataPublicacao = livro.get().getDataPublicacao();
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
	
	
}
