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
import br.com.EstoqueControl.DTO.FornecedorDTO;
import br.com.EstoqueControl.Repository.FornecedorRepository;
import br.com.EstoqueControl.model.Fornecedor;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorRepository repositorio;

    @PostMapping
    public void cadastrarFornecedor(@RequestBody FornecedorDTO dados){
        repositorio.save(new Fornecedor(dados));
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores(){
        var lista = repositorio.findAll();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    public void atualizarProduto(@RequestBody FornecedorDTO dados){
        var produto = repositorio.getReferenceById(dados.id());
        produto.atualizarInformacoes(dados);
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
