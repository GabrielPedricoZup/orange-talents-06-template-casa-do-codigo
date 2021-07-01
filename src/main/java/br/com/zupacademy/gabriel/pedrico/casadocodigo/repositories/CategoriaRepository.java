package br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
		
		Optional<Categoria>findByNome(String nome);
}
