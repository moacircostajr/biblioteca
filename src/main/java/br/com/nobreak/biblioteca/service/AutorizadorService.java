package br.com.nobreak.biblioteca.service;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.nobreak.biblioteca.model.Usuario;
//classe registrada em faces-config.xml
public class AutorizadorService implements PhaseListener {

	@Inject
	FacesContext contexto;

	@Override
	public void afterPhase(PhaseEvent evento) {
		// TODO Auto-generated method stub
		contexto = evento.getFacesContext();
		String nomePagina = contexto.getViewRoot().getViewId();
		if ("/index.xhtml".equals(nomePagina)) {
			return;
		}
		Usuario usuarioLogado = (Usuario) contexto.getExternalContext().getSessionMap().get("usuarioLivraria");
		
		if (usuarioLogado != null) {
			return;
		}
		
		NavigationHandler navegador = contexto.getApplication().getNavigationHandler();
		navegador.handleNavigation(contexto, null, "/index.xhtml?faces-redirect=true");
		contexto.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}

	
}
