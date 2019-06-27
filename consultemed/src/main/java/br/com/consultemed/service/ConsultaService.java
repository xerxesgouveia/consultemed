package br.com.consultemed.service;

import java.util.Date;
import java.util.List;

import br.com.consultemed.dao.AgendamentoDAO;
import br.com.consultemed.dao.ConsultaDAO;
import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Consulta;

/* Classe responsável pelas regras de negócio da entidade horário. */

public class ConsultaService implements IConsulta {

	private ConsultaDAO dao;
	
	public ConsultaService() {
		this.dao = new ConsultaDAO();
	}

	@Override
	public void salvar(Consulta consulta) {
		// TODO Auto-generated method stub
		this.dao.salvar(consulta);
		
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		this.dao.remover(id);
		
	}

	@Override
	public List<Consulta> listar() {
		// TODO Auto-generated method stub
		return this.dao.consultas();
	}

	@Override
	public void editar(Consulta consulta) {
		// TODO Auto-generated method stub
		this.dao.editar(consulta);
		
	}

	@Override
	public Consulta buscaConsultaId(Long idConsulta) {
		// TODO Auto-generated method stub
		return this.dao.buscarPorId(idConsulta);
	}

	@Override
	public List<Consulta> buscaPorData(Date data_inicio, Date data_fim) {
		// TODO Auto-generated method stub
		return this.dao.buscarPorData(data_inicio, data_fim);
	}

}
