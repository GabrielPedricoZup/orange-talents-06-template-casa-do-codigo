package br.com.zupacademy.gabriel.pedrico.casadocodigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms.PaisForm;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Pais;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.PaisRepository;

@RestController
public class PaisController {
		
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping(value = "/pais")
	@Transactional
	public ResponseEntity<PaisForm> cadastrar(@RequestBody @Valid PaisForm paisForm) {

		Pais pais = paisForm.conversor();
		paisRepository.save(pais);
		return ResponseEntity.ok(new PaisForm(pais.getNome()));

	}
}
