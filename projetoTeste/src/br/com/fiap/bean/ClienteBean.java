package br.com.fiap.bean;



import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.ClienteBO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.DBException;


@ManagedBean
public class ClienteBean {
	
	private Cliente cliente;
	private ClienteBO bo;
	
	@PostConstruct
	private void init(){
		
		cliente = new Cliente();
		bo = new ClienteBO();
			
	}
	
	public String Cadastrar(){
		
		
		FacesMessage msg;
		
		try {
			
			bo.cadastrar(cliente);
			msg = new FacesMessage("Cadastrado com sucesso");
			
		} catch (DBException e) {
			
			e.printStackTrace();
			msg= new FacesMessage("OPS! Error");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "cliente?faces-redirect=true";
		
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

}
