package br.com.EstoqueControl.model;

import br.com.EstoqueControl.DTO.FornecedorDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Fornecedor")
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeFornecedor;
    private String cidade;
    @Column(name = "ativo")
    private boolean ativo;

    public Fornecedor(FornecedorDTO dados) {
        this.id = dados.id();
        this.nomeFornecedor = dados.nomeFornecedor();
        this.cidade = dados.cidade();
        this.ativo = true;
    }

    public Fornecedor() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public void atualizarInformacoes(FornecedorDTO dados) {
        if (dados != null) {
            this.id = dados.id();
        }if (dados != null) {
            this.nomeFornecedor = dados.nomeFornecedor();
        }if (dados != null) {
            this.cidade = dados.cidade();
        }
    }
    public void inativar() {
        this.ativo = false;
    }
}
