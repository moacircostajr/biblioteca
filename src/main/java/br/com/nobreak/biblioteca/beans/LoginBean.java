package br.com.nobreak.biblioteca.beans;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.nobreak.biblioteca.dao.UsuarioDao;
import br.com.nobreak.biblioteca.model.Usuario;

import java.io.Serializable;

@Named
@ViewScoped
public class LoginBean implements Serializable {

    @Inject
    FacesContext contexto;
    @Inject
    UsuarioDao usuarioDao;

    Usuario usuarioLogado = new Usuario();

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public String logar() {
        boolean autoriza = usuarioDao.verificarCredenciais(this.usuarioLogado);
        if (autoriza) {
            contexto.getExternalContext().getSessionMap().put("usuarioLivraria", this.usuarioLogado);
            return "livros?faces-redirect=true";
        }
        contexto.getExternalContext().getFlash().setKeepMessages(true);
        contexto.addMessage(null, new FacesMessage("Acesso negado!"));
        return "index?faces-redirect=true";
    }

    public String logout() {
        contexto.getExternalContext().getSessionMap().remove("usuarioLivraria");
        return "index?faces-redirect=true";
    }

}
