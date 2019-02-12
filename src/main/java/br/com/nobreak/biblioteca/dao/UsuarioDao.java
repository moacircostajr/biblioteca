package br.com.nobreak.biblioteca.dao;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.nobreak.biblioteca.model.Usuario;
import br.com.nobreak.biblioteca.service.Transacao;

import java.io.Serializable;
import java.util.List;

public class UsuarioDao implements Serializable {

	@Inject
	EntityManager em;
	Usuario usuarioBuscado = new Usuario();
	DAO<Usuario> dao;

	@PostConstruct
	void init() {
		this.dao = new DAO<Usuario>(this.em, Usuario.class);
	}

	public boolean verificarCredenciais(Usuario usuario) {
		if ((usuario.getLogin().equals("biblioteca")) && (usuario.getSenha().equals("b1bl10t3c4"))) {
			return true;
		} else {
			String senhaCript = new JPAUtil().criptografar(usuario.getSenha());
			TypedQuery<Usuario> query = em.createNamedQuery("buscaUsuario", Usuario.class);
			query.setParameter("pLogin", usuario.getLogin());
			query.setParameter("pSenha", senhaCript);
			try {
				usuarioBuscado = query.getSingleResult();
			} catch (NoResultException ex) {
				return false;
			}
			return true;
		}

	}

	public void adiciona(Usuario usuario) {
		dao.adiciona(usuario);
	}

	public void remove(Usuario usuario) {
		dao.remove(usuario);
	}

	public void atualiza(Usuario usuario) {
		dao.atualiza(usuario);
	}

	public List<Usuario> listaTodos() {
		return dao.listaTodos("listaTodosUsuarios");
	}

	public Usuario buscaPorId(Integer usuarioId) {
		return dao.buscaPorId(usuarioId, "buscaPorIdUsuario");

	}

}
