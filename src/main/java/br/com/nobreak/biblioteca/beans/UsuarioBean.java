package br.com.nobreak.biblioteca.beans;

import br.com.nobreak.biblioteca.dao.JPAUtil;
import br.com.nobreak.biblioteca.dao.UsuarioDao;
import br.com.nobreak.biblioteca.model.Usuario;
import br.com.nobreak.biblioteca.service.Transacao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private Usuario usuario = new Usuario();
	private Integer usuarioId;
	@Inject
	UsuarioDao daoUsuario;
	@Inject
	FacesContext contexto;


	@Transacao
	public void Gravar() {
		String senha = this.usuario.getSenha();
		this.usuario.setSenha(new JPAUtil().criptografar(senha));
		Usuario titularDaSessao = (Usuario) contexto.getExternalContext().getSessionMap().get("usuarioLivraria");
		if (this.getUsuario().getId() == null) {
			this.daoUsuario.adiciona(this.getUsuario());
			contexto.addMessage("usuario", new FacesMessage("Usuário registrado com sucesso!"));
		} else if (this.usuario.getLogin() == titularDaSessao.getLogin()){
			this.daoUsuario.atualiza(this.getUsuario());
		}
	}
	
	public List<Usuario> usuarios(){
		return this.daoUsuario.listaTodos();
	}

	public void carregaAutor(Usuario usuario) {
		this.setUsuario(usuario);
	}

	@Transacao
	public void remover(Usuario usuario){
		this.daoUsuario.remove(usuario);
		this.setUsuario(null);
	}
	
	public void carregarUsuarioPelaId() {
		if (getUsuarioId() != null) {
			this.setUsuario(this.daoUsuario.buscaPorId(this.getUsuarioId()));
		}
	}





	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public void zerar() {
		this.usuario = null;
	}
}
