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
public class FornecedorPutDto {

	private Integer idFornecedor;
	private String nome;
	private String cnpj;
	private String telefone;
}
