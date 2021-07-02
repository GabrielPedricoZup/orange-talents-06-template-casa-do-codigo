package br.com.zupacademy.gabriel.pedrico.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.gabriel.pedrico.casadocodigo.models.Estado;

public interface EstadoRepository extends JpaRepository<Estado,Long> {

	boolean existsByNomeAndPaisNome(String nome,String nomePais);

    Estado findByNome(String estado);

}
