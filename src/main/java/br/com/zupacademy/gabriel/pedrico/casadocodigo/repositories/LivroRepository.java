package br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
