package br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Pais;

public interface PaisRepository extends JpaRepository<Pais,Long> {

	Pais findByNome(String pais);

}
