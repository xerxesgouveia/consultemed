package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.dao.ContatoDAO;
import br.com.consultemed.model.Contato;

/* Classe responsável pelas regras de negócio da entidade contato. */

public class ContatoService implements IContato {

	private ContatoDAO dao;
	
	public ContatoService() {
		this.dao = new ContatoDAO();
	}
	
	@Override
	public void salvar(Contato contato) {
		this.dao.salvar(contato);
	}

	@Override
	public void remover(Long id) {
		
		
	}

	@Override
	public List<Contato> listar() {
		return this.dao.contatos();
	}

	@Override
	public void editar(Contato contato) {
		// TODO Auto-generated method stub
		this.dao.editar(contato);
		
	}

	@Override
	public Contato buscaContatoNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contato buscaContatoEmail(String email) {
		// TODO Auto-generated method stub
		return this.dao.buscarPorEmail(email);
	}

	@Override
	public Contato buscaContatoId(int idContato) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
