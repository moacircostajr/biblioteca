package br.com.nobreak.biblioteca.beans;

import javax.faces.view.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nobreak.biblioteca.dao.AutorDao;
import br.com.nobreak.biblioteca.dao.LivroDao;
import br.com.nobreak.biblioteca.model.Autor;
import br.com.nobreak.biblioteca.model.Livro;
import br.com.nobreak.biblioteca.model.Origem;
import br.com.nobreak.biblioteca.service.Transacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class LivrosBean implements Serializable {


    @Inject
    FacesContext contexto;
    @Inject
    AutorDao autorDao;
    @Inject
    LivroDao livroDao;


    private Livro livro = new Livro();
    private Integer autorId;
    private Integer livroId;
    private List<Livro> livros;




    public Integer getLivroId() {
        return livroId;
    }

    public void setLivroId(Integer livroId) {
        this.livroId = livroId;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public Livro getLivro() {
        return this.livro;
    }

    @Transacao
    public void setLivro() {
        if (livro.getAutores().isEmpty()) {
            contexto.addMessage("autor", new FacesMessage("O livro deve ter pelo menos um autor!"));
            return;
        }
        if (this.livro.getId() == null) {
            if (livroDao.busca(this.livro.getTitulo()) == null) {
                this.livroDao.adiciona(this.livro);
                this.livros = livroDao.listaTodos();
            } else {
                contexto.addMessage("livroDuplicado", new FacesMessage("Este livro já foi cadastrado!"));
            }
        } else {
            livroDao.altera(this.livro);
        }
        this.livro = new Livro();
    }


    @Transacao
    public void gravarAutor(){
        Autor autor = this.autorDao.buscaPorId(autorId);
        this.livro.adicionaAutor(autor);
    }

    public void removerAutor(Autor autor){
        this.livro.removeAutor(autor);
    }

    public List<Autor> getAutoresDoLivro(){
        return this.livro.getAutores();
    }

    public List<Autor> getTodosOsAutores(){
        return this.autorDao.listaTodos();
    }

    public List<Livro> getLivros(){
        if (this.livros == null) {
            this.livros = livroDao.listaTodos();
        }
        return livros;
    }

    public String formAutor() {
        return "autores?faces-redirect=true";
    }

    @Transacao
    public void removerLivro(Livro livro) {
        this.livroDao.remove(livro);
        this.livros = null;
    }

    public void carregarLivro(Livro livro) {
        this.livro = livro;
    }

    public void carregarLivroPelaId() {
        if (livroId != null) {
            this.livro = this.livroDao.buscaPorId(livroId);
        }
    }

    public Origem[] getTipos() {
        return Origem.values();
    }

    public List<String> autoComplete(String query) {
        List<String> resultados = new ArrayList<String>();
        List<Livro> livros = getLivros();
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            if (livro.getTitulo().contains(query)) {
                resultados.add(livro.getTitulo());
            }
        }
        return resultados;
    }
}
