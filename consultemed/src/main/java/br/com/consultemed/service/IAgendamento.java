package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Horario;

public interface IAgendamento {
	public void salvar(Agendamento agendamento);
	public void remover(Long id);
	public List<Agendamento> listar();
	public void editar(Agendamento agendamento);
	public Agendamento buscaAgendamentoId(Long idAgendamento);
}
