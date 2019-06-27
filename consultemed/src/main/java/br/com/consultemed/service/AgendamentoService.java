package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.dao.AgendamentoDAO;
import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Horario;

/* Classe responsável pelas regras de negócio da entidade horário. */

public class AgendamentoService implements IAgendamento {

	private AgendamentoDAO dao;
	
	public AgendamentoService() {
		this.dao = new AgendamentoDAO();
	}

	@Override
	public void salvar(Agendamento agendamento) {
		// TODO Auto-generated method stub
		this.dao.salvar(agendamento);
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		this.dao.remover(id);
	}

	@Override
	public List<Agendamento> listar() {
		// TODO Auto-generated method stub
		return this.dao.agendamentos();
	}

	@Override
	public void editar(Agendamento agendamento) {
		// TODO Auto-generated method stub
		this.dao.editar(agendamento);
	}

	@Override
	public Agendamento buscaAgendamentoId(Long idAgendamento) {
		// TODO Auto-generated method stub
		return this.dao.buscarPorId(idAgendamento);
	}
	
	

}
