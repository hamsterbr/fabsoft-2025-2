package br.univille.fabsoft_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.fabsoft_backend.entity.Solicitacao;
import br.univille.fabsoft_backend.service.SolicitacaoService;

@RestController
@RequestMapping("/api/v1/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService service;
    
    @GetMapping
    public ResponseEntity<List<Solicitacao>> getSolicitacoes() {

        var listaSolicitacoes = service.getAll();
        
        return new ResponseEntity<List<Solicitacao>>(listaSolicitacoes, HttpStatus.OK);
    }
}
