package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.model.Contato;
import br.com.consultemed.model.Medico;

public interface IMedico {
	public void salvar(Medico medico);
	public void remover(Long id);
	public List<Medico> listar();
	public void editar(Medico medico);
	public Medico buscaMedicoNome(String nome);
	public Medico buscaMedicoId(int idMedico);
}
