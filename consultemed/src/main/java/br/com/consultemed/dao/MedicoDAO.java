/**
 * 
 */
package br.com.consultemed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Contato;
import br.com.consultemed.model.Medico;
import br.com.consultemed.utils.JPAUtils;

/**
 * @author Xerxes
 *Classe responsável pelo acesso aos dados do banco
 */
public class MedicoDAO {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Medico medico) {
		factory.getTransaction().begin();
		factory.persist(medico);
		factory.getTransaction().commit();
		factory.close();
	}
	
	public void remover(Long idMedico) {
		this.factory.getTransaction().begin();
		this.factory.remove(buscarPorId(idMedico));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Medico buscarPorId(Long id) {
		this.factory.getTransaction().begin();
		Medico medicoRemover = this.factory.find(Medico.class, id);
		return medicoRemover;
	}
	
	public Medico buscarPorNome(String nome) {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Medico c WHERE c.nome = :nome");
		query.setParameter("nome", nome);
		Medico medico = (Medico) query.getSingleResult();
		this.factory.close();
		return medico;
	}
	
	
	
	public void editar(Medico medico) {
		this.factory.getTransaction().begin();
		Medico medicoEditar = buscarPorId(medico.getId());
		medicoEditar.setId(medico.getId());
		medicoEditar.setNome(medico.getNome());
		medicoEditar.setCrm(medico.getCrm());
		medicoEditar.setHorarios(medico.getHorarios());
		
		this.factory.merge(medicoEditar);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Medico> medicos() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Medico c");
		List<Medico> medicos = query.getResultList();
		for (Medico medico : medicos) {
			System.out.println("Nome do médico: " + medico.getNome());
			System.out.println("CRM do médico: " + medico.getCrm());
			System.out.println("----------------------------------------------------");
		}
		this.factory.close();
		return medicos;
		
	} 

}
