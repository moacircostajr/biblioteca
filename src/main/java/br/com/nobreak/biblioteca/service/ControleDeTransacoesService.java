package br.com.nobreak.biblioteca.service;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import java.io.Serializable;

@Transacao
@Interceptor
public class ControleDeTransacoesService implements Serializable {

    @Inject
    private EntityManager em;

    @AroundInvoke
    public Object controlaTransacao(InvocationContext contexto) throws Exception {
    em.getTransaction().begin();
    Object resultado = contexto.proceed();
    em.getTransaction().commit();
    return resultado;
    }


}
