package br.univille.fabsoft_backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_backend.entity.UserAdm;
import br.univille.fabsoft_backend.repository.UseradmRepository;
import br.univille.fabsoft_backend.service.UseradmService;

@Service
public class UseradmServiceImpl 
    implements UseradmService{

    @Autowired
    private UseradmRepository repository;

    @Override
    public List<UserAdm> getAll() {
        return repository.findAll();
    }

    @Override
    public UserAdm save(UserAdm useradm) {
        return repository.save(useradm);
    }

    @Override
    public UserAdm update(long id, UserAdm useradm) throws Exception{

        var useradmAntigo = repository.getById(id);
        if(useradmAntigo == null){
            throw new Exception("Usuário inexistente");
        }

        useradmAntigo.setMatricula(useradm.getMatricula());
        useradmAntigo.setNomeCompleto(useradm.getNomeCompleto());
        useradmAntigo.setContato(useradm.getContato());
        
        repository.save(useradmAntigo);

        return useradmAntigo;
    }

    @Override
    public UserAdm delete(long id) throws Exception {
        var useradmAntigo = repository.getById(id);
        if(useradmAntigo == null){
            throw new Exception("Usuário inexistente");
        }

        repository.delete(useradmAntigo);
        return useradmAntigo;
    }
}