package br.univille.fabsoft_backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_backend.entity.Tipo;
import br.univille.fabsoft_backend.repository.TipoRepository;
import br.univille.fabsoft_backend.service.TipoService;

@Service
public class TipoServiceImpl 
    implements TipoService{

    @Autowired
    private TipoRepository repository;

    @Override
    public List<Tipo> getAll() {
        return repository.findAll();
    }

    @Override
    public Tipo save(Tipo tipo) {
        return repository.save(tipo);
    }

    @Override
    public Tipo update(long id, Tipo tipo) throws Exception{

        var tipoAntigo = repository.getById(id);
        if(tipoAntigo == null){
            throw new Exception("Cliente inexistente");
        }

        tipoAntigo.setId(tipo.getId());
        tipoAntigo.setValorHora(tipo.getValorHora());
        tipoAntigo.setTipo(tipo.getTipo());
        
        repository.save(tipoAntigo);

        return tipoAntigo;
    }

    @Override
    public Tipo delete(long id) throws Exception {
        var tipoAntigo = repository.getById(id);
        if(tipoAntigo == null){
            throw new Exception("Cliente inexistente");
        }

        repository.delete(tipoAntigo);
        return tipoAntigo;
    }
}