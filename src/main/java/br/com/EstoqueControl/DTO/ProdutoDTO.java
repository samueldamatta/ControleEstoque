package br.com.EstoqueControl.DTO;

import br.com.EstoqueControl.model.Fornecedor;
import jakarta.validation.constraints.NotBlank;

public record ProdutoDTO(
                        @NotBlank
                        Long id,
                        @NotBlank
                        String nome,
                        @NotBlank
                        double preco,
                        @NotBlank
                        int quantidadeEstoque,
                        Fornecedor fornecedor) {
}
