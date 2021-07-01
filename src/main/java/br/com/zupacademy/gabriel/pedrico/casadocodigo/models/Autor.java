package br.com.zupacademy.gabriel.pedrico.casadocodigo.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	private String nomeAutor;

	@NotNull
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;

	@NotNull
	@NotBlank
	@Size(max = 400)
	private String descricao;

	@CreationTimestamp
	private LocalDateTime dataCriacao;

	public Autor(@NotNull @NotBlank String nomeAutor, @NotNull @NotBlank @Email String email,
			@NotNull @NotBlank @Size(max = 400) String descricao) {
		this.nomeAutor = nomeAutor;
		this.email = email;
		this.descricao = descricao;
	}

	@Deprecated
	public Autor() {
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nomeAutor=" + nomeAutor + ", email=" + email + ", descricao=" + descricao
				+ ", dataCriacao=" + dataCriacao + "]";
	}

	public Long getId() {
		return id;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	

}
