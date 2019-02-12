package br.com.nobreak.biblioteca.dao;

import java.util.List;

public interface CRUD<T> {
    public void adiciona(T t);
    public void altera(T t);
    public void remove(T t);
    public List<T> listaTodos();
    public T buscaPorId(Integer id);
    public T busca(String nome);
}
