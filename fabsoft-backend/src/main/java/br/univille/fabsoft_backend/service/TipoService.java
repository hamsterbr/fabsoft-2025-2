package br.univille.fabsoft_backend.service;

import java.util.List;

import br.univille.fabsoft_backend.entity.Tipo;

public interface TipoService {
    List<Tipo> getAll();
    Tipo save(Tipo solicitacao);
    Tipo update(long id, Tipo tipo) throws Exception;
    Tipo delete(long id) throws Exception;
}