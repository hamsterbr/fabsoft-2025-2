package br.univille.fabsoft_backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.fabsoft_backend.entity.UserComum;
import br.univille.fabsoft_backend.repository.UsercomumRepository;
import br.univille.fabsoft_backend.service.UsercomumService;

@Service
public class UsercomumServiceImpl 
    implements UsercomumService{

    @Autowired
    private UsercomumRepository repository;

    @Override
    public List<UserComum> getAll() {
        return repository.findAll();
    }

    @Override
    public UserComum save(UserComum usercomum) {
        return repository.save(usercomum);
    }

    @Override
    public UserComum update(long id, UserComum usercomum) throws Exception{

        var usercomumAntigo = repository.getById(id);
        if(usercomumAntigo == null){
            throw new Exception("Usuário inexistente");
        }

        usercomumAntigo.setMatricula(usercomum.getMatricula());
        usercomumAntigo.setNomeCompleto(usercomum.getNomeCompleto());
        usercomumAntigo.setContato(usercomum.getContato());
        
        repository.save(usercomumAntigo);

        return usercomumAntigo;
    }

    @Override
    public UserComum delete(long id) throws Exception {
        var usercomumAntigo = repository.getById(id);
        if(usercomumAntigo == null){
            throw new Exception("Usuário inexistente");
        }

        repository.delete(usercomumAntigo);
        return usercomumAntigo;
    }
}