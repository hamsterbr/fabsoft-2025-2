package br.univille.fabsoft_backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_backend.entity.Solicitacao;
import br.univille.fabsoft_backend.repository.SolicitacaoRepository;
import br.univille.fabsoft_backend.service.SolicitacaoService;

@Service
public class SolicitacaoServiceImpl 
    implements SolicitacaoService{

    @Autowired
    private SolicitacaoRepository repository;

    @Override
    public List<Solicitacao> getAll() {
        return repository.findAll();
    }

    @Override
    public Solicitacao save(Solicitacao solicitacao) {
        return repository.save(solicitacao);
    }

    @Override
    public Solicitacao update(long id, Solicitacao solicitacao) throws Exception{

        var solicitacaoAntiga = repository.getById(id);
        if(solicitacaoAntiga == null){
            throw new Exception("Cliente inexistente");
        }

        solicitacaoAntiga.setId(solicitacao.getId());
        solicitacaoAntiga.setData(solicitacao.getData());
        solicitacaoAntiga.setHoraInicio(solicitacao.getHoraInicio());
        solicitacaoAntiga.setHoraFim(solicitacao.getHoraFim());
        solicitacaoAntiga.setDescricao(solicitacao.getDescricao());
        
        repository.save(solicitacaoAntiga);

        return solicitacaoAntiga;
    }

    @Override
    public Solicitacao delete(long id) throws Exception {
        var solicitacaoAntiga = repository.getById(id);
        if(solicitacaoAntiga == null){
            throw new Exception("Cliente inexistente");
        }

        repository.delete(solicitacaoAntiga);
        return solicitacaoAntiga;
    }
}