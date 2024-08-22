package br.com.EstoqueControl.DTO;

import jakarta.validation.constraints.NotBlank;

public record ProdutoDTO(
                        @NotBlank
                        Long id,
                        @NotBlank
                        String nome,
                        @NotBlank
                        double preco,
                        @NotBlank
                        int quantidadeEstoque) {
}
