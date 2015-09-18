package br.com.mvcampos.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.mvcampos.drogaria.dao.EstadoDAO;
import br.com.mvcampos.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

		} catch (Exception e) {
			Messages.addGlobalError("Ocorreu um erro ao listar os estados.");
			e.printStackTrace();
		}
	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {

		/*
		 * String msg= "Nome: " + estado.getNome() + " Sigla: " +
		 * estado.getSigla(); FacesMessage message = new
		 * FacesMessage(FacesMessage.SEVERITY_INFO, msg , msg);
		 * 
		 * FacesContext ctx = FacesContext.getCurrentInstance();
		 * ctx.addMessage(null, message);
		 */
		try {

			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);

			novo();
			estados = estadoDAO.listar();

			Messages.addGlobalInfo("Estado salvo com sucesso!");
		} catch (RuntimeException e) {
			
			Messages.addGlobalError("Ocorreu um erro ao salvar o estado: ");
			e.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");

			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			
			estados = estadoDAO.listar();

			Messages.addGlobalInfo("Estado removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o estado");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");

		
	}

}
