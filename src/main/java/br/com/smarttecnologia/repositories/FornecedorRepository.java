package br.com.smarttecnologia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.smarttecnologia.entities.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{

	@Query("select f from Fornecedor f order by f.nome")
	List<Fornecedor> findAll();
}
