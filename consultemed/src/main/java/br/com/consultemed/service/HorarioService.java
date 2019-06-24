package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.dao.HorarioDAO;
import br.com.consultemed.model.Horario;

/* Classe responsável pelas regras de negócio da entidade horário. */

public class HorarioService implements IHorario {

	private HorarioDAO dao;
	
	public HorarioService() {
		this.dao = new HorarioDAO();
	}

	@Override
	public void salvar(Horario horario) {
		// TODO Auto-generated method stub
		this.dao.salvar(horario);
		
		
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Horario> listar() {
		// TODO Auto-generated method stub
		return this.dao.horarios();
	}

	@Override
	public void editar(Horario horario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Horario buscaHorarioId(int idHorario) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
