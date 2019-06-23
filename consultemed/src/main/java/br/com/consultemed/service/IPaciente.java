package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.model.Contato;
import br.com.consultemed.model.Paciente;

public interface IPaciente {
	public void salvar(Paciente paciente);
	public void remover(Long id);
	public List<Paciente> listar();
	public void editar(Paciente paciente);
	public Paciente buscaPacienteNome(String nome);
	public Paciente buscaPacienteEmail(String email);
	public Paciente buscaPacienteId(int idContato);

}
