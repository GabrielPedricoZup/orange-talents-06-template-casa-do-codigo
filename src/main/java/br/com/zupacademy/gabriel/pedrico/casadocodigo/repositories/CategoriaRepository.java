package br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
		
		Optional<Categoria>findByNome(String nome);
}
