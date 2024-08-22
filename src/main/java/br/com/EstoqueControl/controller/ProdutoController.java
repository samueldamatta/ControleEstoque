package br.com.EstoqueControl.controller;

import java.util.List;
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
import br.com.EstoqueControl.DTO.ProdutoDTO;
import br.com.EstoqueControl.Repository.ProdutoRepository;
import br.com.EstoqueControl.model.Produto;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repositorio;

    @PostMapping
    public void cadastrarProduto(@RequestBody ProdutoDTO dados){
        repositorio.save(new Produto(dados));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        var lista = repositorio.findAll();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    public void atualizarProduto(@RequestBody ProdutoDTO dados){
        var produto = repositorio.getReferenceById(dados.id());
        produto.atuaizarInformacoes(dados);
    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativarProduto(@PathVariable Long id){
        var produto = repositorio.getReferenceById(id);
        produto.inativar();

        return ResponseEntity.noContent().build();
    }
}