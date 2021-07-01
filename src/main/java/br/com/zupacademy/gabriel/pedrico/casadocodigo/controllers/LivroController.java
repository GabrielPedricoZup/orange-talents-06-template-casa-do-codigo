package br.com.zupacademy.gabriel.pedrico.casadocodigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping(value="/livros")
	@Transactional
	public String cadastrar (@RequestBody @Valid LivroForm livroForm) {
		
		Livro livro = livroForm.conversor(autorRepository,categoriaRepository);
		livroRepository.save(livro);
		return livro.toString();
		
	}
	
}
