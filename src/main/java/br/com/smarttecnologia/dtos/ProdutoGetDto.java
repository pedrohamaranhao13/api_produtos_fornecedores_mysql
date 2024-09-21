package br.com.smarttecnologia.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProdutoGetDto {

	private Integer idProduto;
	private String nomeProduto;
	private Double preco;
	private Integer quantidade;
	private Double total;
	private String descricao;
	private Integer idFornecedor;
	private String nomeFornecedor;
	private String cnpjFornecedor;
	private String telefoneFornecedor;
	
}
