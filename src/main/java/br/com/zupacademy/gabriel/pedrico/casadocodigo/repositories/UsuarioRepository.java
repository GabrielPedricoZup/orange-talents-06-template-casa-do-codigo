package br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
