package br.univille.fabsoft_backend.service;

import java.util.List;

import br.univille.fabsoft_backend.entity.UserAdm;

public interface UseradmService {
    List<UserAdm> getAll();
    UserAdm save(UserAdm useradm);
    UserAdm update(long id, UserAdm useradm) throws Exception;
    UserAdm delete(long id) throws Exception;
}