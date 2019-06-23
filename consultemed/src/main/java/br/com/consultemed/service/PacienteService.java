package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.dao.PacienteDAO;
import br.com.consultemed.model.Paciente;

/* Classe responsável pelas regras de negócio da entidade paciente. */

public class PacienteService implements IPaciente {

	private PacienteDAO dao;
	
	public PacienteService() {
		this.dao = new PacienteDAO();
	}
	
	@Override
	public void salvar(Paciente paciente) {
		this.dao.salvar(paciente);
	}

	@Override
	public void remover(Long id) {
		
		
	}

	@Override
	public List<Paciente> listar() {
		return this.dao.pacientes();
	}

	@Override
	public void editar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.dao.editar(paciente);
		
	}

	@Override
	public Paciente buscaPacienteNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente buscaPacienteEmail(String email) {
		// TODO Auto-generated method stub
		return this.dao.buscarPorEmail(email);
	}

	@Override
	public Paciente buscaPacienteId(int idPaciente) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
