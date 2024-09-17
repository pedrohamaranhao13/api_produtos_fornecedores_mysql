package br.com.smarttecnologia.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smarttecnologia.dtos.ProdutoPostDto;
import br.com.smarttecnologia.dtos.ProdutoPutDto;
import br.com.smarttecnologia.entities.Fornecedor;
import br.com.smarttecnologia.entities.Produto;
import br.com.smarttecnologia.repositories.FornecedorRepository;
import br.com.smarttecnologia.repositories.ProdutoRepository;


@RestController
@RequestMapping(value = "/api/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@PostMapping
	public ResponseEntity<String> post(@RequestBody ProdutoPostDto dto) {
		try {
			
			Optional<Fornecedor> optional = fornecedorRepository.findById(dto.getIdFornecedor());
			
			if (optional.isPresent()) {
				
				Fornecedor fornecedor = optional.get();
				
				Produto produto = new Produto();
				produto.setNome(dto.getNome());
				produto.setPreco(dto.getPreco());
				produto.setQuantidade(dto.getQuantidade());
				produto.setDescricao(dto.getDescricao());
				produto.setFornecedor(fornecedor);
				
				produtoRepository.save(produto);
				
				return ResponseEntity.status(201).body("Produto criado com sucesso.");
				
			} else {
				return ResponseEntity.status(404).body("Fornecedor não encontrado, verique o ID informado.");
			}
			
			
			
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Não foi possível criar produto. " + e.getMessage());
		}

	}
	
	@PutMapping
	public ResponseEntity<String> put(@RequestBody ProdutoPutDto dto) {
		try {
			Optional<Produto> optionalProduto = produtoRepository.findById(dto.getIdProduto());
			
			
			if (optionalProduto.isPresent()) {
				Optional<Fornecedor> optionalFornecedor = fornecedorRepository.findById(dto.getIdFornecedor());
				if (optionalFornecedor.isPresent()) {
					
					Produto produto = optionalProduto.get();
					Fornecedor fornecedor = optionalFornecedor.get();
					produto.setNome(dto.getNome());
					produto.setPreco(dto.getPreco());
					produto.setQuantidade(dto.getQuantidade());
					produto.setDescricao(dto.getDescricao());
					produto.setFornecedor(fornecedor);
					
					produtoRepository.save(produto);
					
					return ResponseEntity.status(200).body("Produto atualizado com sucesso.");
				} 
				else {
					return ResponseEntity.status(404).body("Fornecedor não encontrado.");
				}
				
			} 
			else {
				return ResponseEntity.status(404).body("Produto não encontrado.");
			}
	
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Não foi possível atualizar produto.");
		}

	}
	
	@DeleteMapping("{idProduto}")
	public ResponseEntity<String> delete(@PathVariable("idProduto") Integer idProduto) {
		try {
			
			Optional<Produto> optional = produtoRepository.findById(idProduto);
			
			if (optional.isPresent()) {
				
				Produto produto = optional.get();
				produtoRepository.delete(produto);
				return ResponseEntity.status(200).body("Produto excluído com sucesso.");
				
			} else {
				return ResponseEntity.status(404).body("Produto não encontrado.");
			}
			
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Não foi possível excluir produto.");
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		try {
			
			List<Produto> produtos = produtoRepository.findAll();
			
			return ResponseEntity.status(200).body(produtos);
			
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}
	
	@GetMapping("{idProduto}")
	public ResponseEntity<Produto> getById(@PathVariable("idProduto") Integer idProduto) {
		
		try {
			
			Optional<Produto> optional = produtoRepository.findById(idProduto);
			
			if (optional.isPresent()) {
				
				Produto produto = optional.get();
				return ResponseEntity.status(200).body(produto);
				
			} else {
				return ResponseEntity.status(204).body(null);
			}
			
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
		
	}
	
	
}
