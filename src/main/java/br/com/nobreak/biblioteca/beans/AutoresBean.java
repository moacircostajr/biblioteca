package br.com.nobreak.biblioteca.beans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nobreak.biblioteca.dao.AutorDao;
import br.com.nobreak.biblioteca.model.Autor;
import br.com.nobreak.biblioteca.service.Transacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class AutoresBean implements Serializable {

        @Inject
        private AutorDao autorDao;
        @Inject
        FacesContext contexto;
        private Autor autor = new Autor();
        private Integer autorId;



        public Integer getAutorId() {
            return autorId;
        }

        public void setAutorId(Integer autorId) {
            this.autorId = autorId;
        }

        public Autor getAutor() {
            return autor;
        }

        public void setAutor(Autor autor) {
            this.autor = autor;
        }


        @Transacao
        public void Gravar() {
            if (this.autor.getId() == null) {
                if (autorDao.busca(this.autor.getNome())==null) {
                    this.autorDao.adiciona(this.autor);
                } else {
                    contexto.addMessage("autorDuplicado", new FacesMessage("Este autor já foi cadastrado!"));
                }
            } else {
                this.autorDao.altera(this.autor);
            }
            carregaAutor(new Autor());
        }

        public List<Autor> autores(){
            return this.autorDao.listaTodos();
        }

        public void carregaAutor(Autor autor) {
            this.autor = autor;
        }

        @Transacao
        public void remover(Autor autor){
            this.autorDao.remove(autor);
        }

        public void carregarAutorPelaId() {
            if (autorId != null) {
                this.autor = this.autorDao.buscaPorId(this.autorId);
            }
        }

        public List<String> autoComplete(String query) {
            List<String> resultados = new ArrayList<String>();
            List<Autor> autores = autores();
            for (int i = 0; i < autores.size(); i++) {
                Autor autor = autores.get(i);
                if (autor.getNome().contains(query)) {
                    resultados.add(autor.getNome());
                }
            }
            return resultados;
        }
}
