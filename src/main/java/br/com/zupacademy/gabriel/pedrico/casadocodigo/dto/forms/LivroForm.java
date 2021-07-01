package br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms;

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

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Autor;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Categoria;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Livro;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.validators.ExistsId;

public class LivroForm {

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

	public LivroForm(@NotNull @NotBlank String titulo, @NotNull @NotBlank @Size(max = 500) String resumo,
			String sumario, @Positive @Min(20) @NotNull BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas,
			@NotNull @NotBlank String isbn, @Future LocalDate dataPublicacao, @NotNull Long idCategoria,
			@NotNull Long idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	@Deprecated
	public LivroForm() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public Livro conversor(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {

		Optional<Autor> autor = autorRepository.findById(idAutor);
		Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);

		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn,
				this.dataPublicacao, categoria.get(), autor.get());
	}
}
