/**
 * 
 */
package br.com.consultemed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Horario;
import br.com.consultemed.utils.JPAUtils;

/**
 * @author Xerxes
 *Classe responsável pelo acesso aos dados do banco
 */
public class AgendamentoDAO {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Agendamento agendamento) {
		factory.getTransaction().begin();
		factory.persist(agendamento);
		factory.getTransaction().commit();
		factory.close();
	}
	
	public void remover(Long idAgendamento) {
		this.factory.getTransaction().begin();
		this.factory.remove(buscarPorId(idAgendamento));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Agendamento buscarPorId(Long id) {
		this.factory.getTransaction().begin();
		Agendamento agendamentoRemover = this.factory.find(Agendamento.class, id);
		return agendamentoRemover;
	}
	
	public void editar(Agendamento agendamento) {
		this.factory.getTransaction().begin();
		Agendamento agendamentoEditar = buscarPorId(agendamento.getId());
		agendamentoEditar.setId(agendamento.getId());
		agendamentoEditar.setMedico(agendamento.getMedico());
		agendamentoEditar.setPaciente(agendamento.getPaciente());
		agendamentoEditar.setDataHora(agendamento.getDataHora());
		
		this.factory.merge(agendamentoEditar);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Agendamento> agendamentos() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Agendamento c");
		List<Agendamento> agendamentos = query.getResultList();
		for (Agendamento agendamento : agendamentos) {
			System.out.println("Paciente: " + agendamento.getPaciente().getNome());
			System.out.println("Médico: " + agendamento.getMedico().getNome());
			System.out.println("Data: " + agendamento.getDataHora().toString());
			System.out.println("----------------------------------------------------");
		}
		this.factory.close();
		return agendamentos;
		
	} 

}
