package br.com.consultemed.service;

import java.util.Date;
import java.util.List;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Consulta;

public interface IConsulta {
	public void salvar(Consulta consulta);
	public void remover(Long id);
	public List<Consulta> listar();
	public void editar(Consulta consulta);
	public Consulta buscaConsultaId(Long idConsulta);
	public List<Consulta> buscaPorData(Date data_inicio, Date data_fim);
}
