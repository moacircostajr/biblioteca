package br.com.nobreak.biblioteca.dao;

import br.com.nobreak.biblioteca.model.Livro;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class LivroDao implements CRUD<Livro>, Serializable {

    @Inject
    EntityManager em;
    DAO<Livro> dao;

    @PostConstruct
    private void init() {
        this.dao = new DAO<Livro>(this.em, Livro.class);
    }

    @Override
    public void adiciona(Livro livro) {
        this.dao.adiciona(livro);
    }

    @Override
    public void altera(Livro livro) {
        this.dao.atualiza(livro);
    }

    @Override
    public void remove(Livro livro) {
        this.dao.remove(livro);
    }

    @Override
    public List<Livro> listaTodos() {
        return this.dao.listaTodos("listaTodosLivros");
    }

    @Override
    public Livro buscaPorId(Integer id) {
        return this.dao.buscaPorId(id, "buscaPorIdLivro");
    }

    @Override
    public Livro busca(String nome) {
        return this.dao.busca(nome, "buscaPorLivro");
    }
}
