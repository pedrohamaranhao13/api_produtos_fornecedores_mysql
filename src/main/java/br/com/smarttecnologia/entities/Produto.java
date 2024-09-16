package br.com.smarttecnologia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produto")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproduto")
	private Integer idProduto;
	
	@Column(name = "nome", length = 150, nullable = false)
	private String nome; 
	
	@Column(name = "preco", nullable = false)
	private Double preco;
	
	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "descricao", length = 250, nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "idfornecedor", nullable = false)
	private Fornecedor fornecedor;
}
