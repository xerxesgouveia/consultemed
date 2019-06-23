package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.model.Contato;

public interface IContato {
	public void salvar(Contato contato);
	public void remover(Long id);
	public List<Contato> listar();
	public void editar(Contato contato);
	public Contato buscaContatoNome(String nome);
	public Contato buscaContatoEmail(String email);
	public Contato buscaContatoId(int idContato);
}
