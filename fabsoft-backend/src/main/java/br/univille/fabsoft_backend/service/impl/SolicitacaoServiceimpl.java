package br.univille.fabsoft_backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.fabsoft_backend.entity.Solicitacao;
import br.univille.fabsoft_backend.repository.SolicitacaoRepository;
import br.univille.fabsoft_backend.service.SolicitacaoService;
import jakarta.validation.Valid;

@Service
public class SolicitacaoServiceimpl 
    implements SolicitacaoService{

    @Autowired
    private SolicitacaoRepository repository;

    @Override
    public List<Solicitacao> getAll() {
        return repository.findAll();
    }

    @Override
    public Solicitacao update(long id, Solicitacao solicitacao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public @Valid Solicitacao save(Solicitacao solicitacao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }


}
