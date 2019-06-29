/**
 * 
 */
package br.com.consultemed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Consulta;
import br.com.consultemed.model.Horario;
import br.com.consultemed.utils.JPAUtils;

/**
 * @author Xerxes
 *Classe responsável pelo acesso aos dados do banco
 */
public class HorarioDAO {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Horario horario) {
		factory.getTransaction().begin();
		factory.persist(horario);
		factory.getTransaction().commit();
		factory.close();
	}
	
	public void remover(Long idHorario) {
		this.factory.getTransaction().begin();
		this.factory.remove(buscarPorId(idHorario));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Horario buscarPorId(Long id) {
		this.factory.getTransaction().begin();
		Horario horarioRemover = this.factory.find(Horario.class, id);
		return horarioRemover;
	}
	
	public void editar(Horario horario) {
		this.factory.getTransaction().begin();
		Horario horarioEditar = buscarPorId(horario.getId());
		horarioEditar.setId(horario.getId());
		//horarioEditar.setMedico(horario.getMedico());
		horarioEditar.setData(horario.getData());
		
		this.factory.merge(horarioEditar);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Horario> horarios() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Horario c");
		List<Horario> horarios = query.getResultList();
		for (Horario horario : horarios) {
			System.out.println("Data: " + horario.getData().toString());
			System.out.println("----------------------------------------------------");
		}
		this.factory.close();
		return horarios;
		
	}
	

}
