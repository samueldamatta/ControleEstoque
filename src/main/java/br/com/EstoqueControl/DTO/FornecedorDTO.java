package br.com.EstoqueControl.DTO;

import jakarta.validation.constraints.NotBlank;

public record FornecedorDTO(@NotBlank
                            Long id,
                            @NotBlank
                            String nomeFornecedor,
                            @NotBlank
                            String cidade) {
}
