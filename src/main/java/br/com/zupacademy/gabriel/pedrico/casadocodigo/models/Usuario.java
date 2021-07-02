package br.com.zupacademy.gabriel.pedrico.casadocodigo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@Email
	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@ManyToOne
	@NotNull
	private Pais pais;

	@ManyToOne
	private Estado estado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public Usuario(@NotBlank String nome, @NotBlank String sobrenome, @Email String email, String documento,
			@NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Pais pais,
			Estado estado, @NotBlank String telefone, @NotBlank String cep) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	@Deprecated
	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", pais=" + pais + ", estado=" + estado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}
	
	

}
