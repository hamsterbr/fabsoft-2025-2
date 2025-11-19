package br.univille.fabsoft_backend.service;

import java.util.List;

import br.univille.fabsoft_backend.entity.UserComum;

public interface UsercomumService {
    List<UserComum> getAll();
    UserComum save(UserComum usercomum);
    UserComum update(long id, UserComum usercomum) throws Exception;
    UserComum delete(long id) throws Exception;
}