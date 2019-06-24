package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.dao.MedicoDAO;
import br.com.consultemed.model.Contato;
import br.com.consultemed.model.Medico;

/* Classe responsável pelas regras de negócio da entidade médico. */

public class MedicoService implements IMedico {

	private MedicoDAO dao;
	
	public MedicoService() {
		this.dao = new MedicoDAO();
	}

	@Override
	public void salvar(Medico medico) {
		// TODO Auto-generated method stub
		this.dao.salvar(medico);
		
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Medico> listar() {
		// TODO Auto-generated method stub
		return this.dao.medicos();
	}

	@Override
	public void editar(Medico medico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medico buscaMedicoNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico buscaMedicoId(int idMedico) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
