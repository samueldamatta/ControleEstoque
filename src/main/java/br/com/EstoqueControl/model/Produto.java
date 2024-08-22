package br.com.EstoqueControl.model;

import br.com.EstoqueControl.DTO.ProdutoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private Boolean ativo;

    public Produto(ProdutoDTO dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.quantidadeEstoque = dados.quantidadeEstoque();
        this.ativo = true;
    }

    public Produto() {
    }

    public void atuaizarInformacoes(ProdutoDTO dados){
        if (dados != null) {
            this.id = dados.id();
        }if (dados != null) {
            this.nome = dados.nome();
        }if (dados != null) {
            this.preco = dados.preco();
        }if (dados != null) {
            this.quantidadeEstoque = dados.quantidadeEstoque();
        }
    }

    public void inativar(){
        this.ativo = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
