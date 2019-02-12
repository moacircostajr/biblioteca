package br.com.nobreak.biblioteca.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("biblioteca");

	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close(@Disposes EntityManager em) {
		em.close();
	}

	public String criptografar(String s) {
		MessageDigest m= null;

		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			return "Erro na execução da criptografia.";
		}

		try {
			m.update(s.getBytes(), 0, s.length());
		} catch (NullPointerException ex) {
			return "Erro ao criptografar a senha. Valor nulo.";
		}

		return new BigInteger(1,m.digest()).toString(16);
	}
}
