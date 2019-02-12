package br.com.nobreak.biblioteca.dao;

import br.com.nobreak.biblioteca.service.Transacao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class DAO<T> implements Serializable {

	private final Class<T> classe;
	private EntityManager em;

	public DAO(EntityManager manager, Class<T> classe) {
		this.em = manager;
		this.classe = classe;
	}

	public void adiciona(T t) {
		em.persist(t);
	}

	public void remove(T t) {
		em.remove(em.merge(t));
	}

	public void atualiza(T t) {
		em.merge(t);
	}

	public List<T> listaTodos(String jpql) {
		TypedQuery<T> typedQuery = em.createNamedQuery(jpql, classe);
		return typedQuery.getResultList();
	}

	public T buscaPorId(Integer id, String jpql) {
		TypedQuery<T> typedQuery = em.createNamedQuery(jpql, classe);
		typedQuery.setParameter("pId", id);
		return typedQuery.getSingleResult();
	}

	public T busca(String nome, String jpql) {
		try {
			TypedQuery<T> typedQuery = em.createNamedQuery(jpql, classe);
			typedQuery.setParameter("pNome", nome);
			return typedQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
