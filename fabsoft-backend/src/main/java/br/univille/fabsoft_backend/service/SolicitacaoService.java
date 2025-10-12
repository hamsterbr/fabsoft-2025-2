package br.univille.fabsoft_backend.service;

import java.util.List;

import br.univille.fabsoft_backend.entity.Solicitacao;

public interface SolicitacaoService {
    List<Solicitacao> getAll();
    Solicitacao save(Solicitacao solicitacao);
    Solicitacao update(long id, Solicitacao solicitacao) throws Exception;
    Solicitacao delete(long id) throws Exception;
}