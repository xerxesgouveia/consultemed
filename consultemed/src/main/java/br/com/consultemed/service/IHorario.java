package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.model.Horario;
import br.com.consultemed.model.Medico;

public interface IHorario {
	public void salvar(Horario horario);
	public void remover(Long id);
	public List<Horario> listar();
	public void editar(Horario horario);
	public Horario buscaHorarioId(int idHorario);
}
