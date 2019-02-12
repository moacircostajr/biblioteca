package br.com.nobreak.biblioteca.dao;

import br.com.nobreak.biblioteca.model.Autor;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class AutorDao implements CRUD<Autor>, Serializable {

    @Inject
    EntityManager em;
    DAO<Autor> dao;

    @PostConstruct
    private void init(){
        this.dao = new DAO<Autor>(this.em, Autor.class);
    }


    @Override
    public void adiciona(Autor autor) {
        this.dao.adiciona(autor);
    }

    @Override
    public void altera(Autor autor) {
        this.dao.atualiza(autor);
    }

    @Override
    public void remove(Autor autor) {
        this.dao.remove(autor);
    }

    @Override
    public List<Autor> listaTodos() {
        return this.dao.listaTodos("listaTodosAutores");
    }

    @Override
    public Autor buscaPorId(Integer id) {
        return this.dao.buscaPorId(id, "buscaPorIdAutor");
    }

    @Override
    public Autor busca(String nome) {
        return this.dao.busca(nome, "buscaPorNome");
    }
}
