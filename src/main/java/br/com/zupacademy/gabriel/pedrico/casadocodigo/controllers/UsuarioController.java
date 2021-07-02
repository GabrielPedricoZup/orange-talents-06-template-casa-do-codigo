package br.com.zupacademy.gabriel.pedrico.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.dto.forms.UsuarioForm;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Usuario;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.PaisRepository;
import br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories.UsuarioRepository;

@RestController
public class UsuarioController {
			
		@Autowired
		UsuarioRepository usuarioRepository;
		
		@Autowired
		EstadoRepository estadoRepository;
		
		@Autowired
		PaisRepository paisRepository;
		
		
		@PostMapping(value="/usuario")
		public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm){
			
			Usuario usuario = usuarioForm.conversor(paisRepository,estadoRepository);
			usuarioRepository.save(usuario);
			return ResponseEntity.ok().body(usuario);
		}
}
