package br.com.zupacademy.gabriel.pedrico.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Autor;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Categoria;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Livro;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.validators.ExistsId;

public class LivroDto {
			
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

	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Long idCategoria;

	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id")
	private Long idAutor;

	

	public LivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.idCategoria = livro.getCategoria().getId();
		this.idAutor = livro.getAutor().getId();
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

	public Long getIdCategoria() {
		return idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}
	
	public static List<LivroDto> converter(List<Livro> livros){
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}
}
