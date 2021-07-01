package br.com.zupacademy.gabriel.pedrico.casadocodigo.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.LivroDetalhesDto;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.LivroDto;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms.LivroForm;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Livro;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.LivroRepository;

@RestController
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private AutorRepository autorRepository;

	@PostMapping(value = "/livros")
	@Transactional
	public String cadastrar(@RequestBody @Valid LivroForm livroForm) {

		Livro livro = livroForm.conversor(autorRepository, categoriaRepository);
		livroRepository.save(livro);
		return livro.toString();

	}

	@GetMapping(value = "/livros")
	public List<LivroDto> listar() {

		List<Livro> livros = livroRepository.findAll();

		return LivroDto.converter(livros);

	}
	
	@GetMapping(value = "/livros/{id}")
	public ResponseEntity<?> listarLivro(@PathVariable("id") Long id) {

		Optional<Livro> livro = livroRepository.findById(id);
		
		if(livro.isPresent()) {
			LivroDetalhesDto livroDetalhesDto = new LivroDetalhesDto(livro);
			return ResponseEntity.ok(livroDetalhesDto);
		}
		return ResponseEntity.notFound().build();
		

	}

}
