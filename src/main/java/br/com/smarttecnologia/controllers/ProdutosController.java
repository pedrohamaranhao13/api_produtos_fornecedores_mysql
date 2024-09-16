package br.com.smarttecnologia.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smarttecnologia.dtos.ProdutoPostDto;
import br.com.smarttecnologia.dtos.ProdutoPutDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutosController {

	@PostMapping
	public void post(@RequestBody ProdutoPostDto dto) {
		// TODO
	}
	
	@PutMapping
	public void put(@RequestBody ProdutoPutDto dto) {
		// TODO
	}
	
	@DeleteMapping("{idProduto}")
	public void delete(@PathVariable("idProduto") Integer idProduto) {
		// TODO
	}
	
	@GetMapping
	public void getAll() {
		// TODO
	}
	
	@GetMapping("{idProduto}")
	public void getById(@PathVariable("idProduto") Integer idProduto) {
		// TODO
	}
	
	
}
