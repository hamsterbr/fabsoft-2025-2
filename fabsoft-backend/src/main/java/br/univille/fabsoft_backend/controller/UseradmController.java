package br.univille.fabsoft_backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import br.univille.fabsoft_backend.entity.Solicitacao;
import br.univille.fabsoft_backend.service.SolicitacaoService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/solicitacoes")
public class UseradmController {

    @Autowired
    private SolicitacaoService service;
    
    @GetMapping
    public ResponseEntity<List<Solicitacao>> getSolicitacoes() {

        var listaSolicitacoes = service.getAll();
        
        return new ResponseEntity<List<Solicitacao>>(listaSolicitacoes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Solicitacao> save(@Valid @RequestBody Solicitacao solicitacao, BindingResult result){
        if (solicitacao == null){
            return ResponseEntity.badRequest().build();
        }
        if (result.hasErrors()) {
            HttpHeaders headers = new HttpHeaders();
            String errorMessages = result.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(" "));
                return new ResponseEntity<Solicitacao>(solicitacao, headers, HttpStatus.BAD_REQUEST);
        }
        if (solicitacao.getId() == 0) {
            solicitacao = service.save(solicitacao);
            return new ResponseEntity<Solicitacao>(solicitacao, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Solicitacao> update(@RequestBody Solicitacao solicitacao, @PathVariable long id) {

        if (id <= 0 || solicitacao == null){
            return ResponseEntity.badRequest().build();
        }

        solicitacao = service.update(id, solicitacao);
        return new ResponseEntity<Solicitacao>(solicitacao, HttpStatus.OK);
    }
}
