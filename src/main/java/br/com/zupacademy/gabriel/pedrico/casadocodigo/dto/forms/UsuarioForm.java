package br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Estado;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Pais;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Usuario;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.PaisRepository;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.validators.CPFouCNPJ;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.validators.Exists;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.validators.UniqueValue;

public class UsuarioForm {
	
	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@Email
	@UniqueValue(domainClass=Usuario.class,fieldName="email",message="Email já cadastrado")
	private String email;

	@CPF
	@CPFouCNPJ
	@UniqueValue(domainClass=Usuario.class,fieldName="documento",message="Documento já cadastrado")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@ManyToOne
	@NotBlank
	@Exists(domainClass=Pais.class,fieldName="nome",message="Pais não encontrado")
	private String pais;

	@ManyToOne
	private String estado;

	@NotBlank
	private String telefone;

	@NotBlank
	private String cep;

	public UsuarioForm(@NotBlank String nome, @NotBlank String sobrenome, @Email String email, @CPF String documento,
			@NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotBlank String pais,
			String estado, @NotBlank String telefone, @NotBlank String cep) {
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
	public UsuarioForm () {
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Usuario conversor(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		
		Pais pais = paisRepository.findByNome(this.pais);
		Estado estado = estadoRepository.findByNome(this.estado);
		Usuario usuario = new Usuario(this.nome,this.sobrenome,this.email,this.documento,this.endereco,this.complemento,
									  this.cidade,pais,estado,this.telefone,this.cep);
		return usuario;
	}
	
}
