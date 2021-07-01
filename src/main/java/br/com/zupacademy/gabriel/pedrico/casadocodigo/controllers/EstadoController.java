package br.com.zupacademy.gabriel.pedrico.casadocodigo.controllers;

import java.net.BindException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.compartilhado.outputs.FieldErrorOutput;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms.EstadoForm;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Estado;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.PaisRepository;

@RestController
//@RequestMapping(value="/estado")
public class EstadoController {

	private final EstadoRepository estadoRepository;

	private final PaisRepository paisRepository;

	public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		this.estadoRepository = estadoRepository;
		this.paisRepository = paisRepository;
	}

	@PostMapping(value = "/estado")
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoForm estadoForm) throws BindException {
		if (estadoRepository.existsByNomeAndPaisNome(estadoForm.getNome(),estadoForm.getPais())) {
			return ResponseEntity.badRequest().body(new FieldErrorOutput("estado", "Estado já cadastrado para esse pais."));
		}
			Estado estado = estadoForm.conversor(paisRepository);
			estadoRepository.save(estado);
			return ResponseEntity.ok(new EstadoForm(estado.getNome(), estado.getPais().getNome()));
	}

}
