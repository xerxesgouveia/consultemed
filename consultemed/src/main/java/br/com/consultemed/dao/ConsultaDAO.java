/**
 * 
 */
package br.com.consultemed.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Consulta;
import br.com.consultemed.model.Medico;
import br.com.consultemed.utils.JPAUtils;

/**
 * @author Xerxes
 *Classe responsável pelo acesso aos dados do banco
 */
public class ConsultaDAO {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Consulta consulta) {
		factory.getTransaction().begin();
		factory.persist(consulta);
		factory.getTransaction().commit();
		factory.close();
	}
	
	public void remover(Long idConsulta) {
		this.factory.getTransaction().begin();
		this.factory.remove(buscarPorId(idConsulta));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Consulta buscarPorId(Long id) {
		this.factory.getTransaction().begin();
		Consulta consultaRemover = this.factory.find(Consulta.class, id);
		return consultaRemover;
	}
	
	public void editar(Consulta consulta) {
		this.factory.getTransaction().begin();
		Consulta consultaEditar = buscarPorId(consulta.getId());
		consultaEditar.setId(consulta.getId());
		consultaEditar.setMedico(consulta.getMedico());
		consultaEditar.setPaciente(consulta.getPaciente());
		consultaEditar.setDataHora(consulta.getDataHora());
		
		this.factory.merge(consultaEditar);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Consulta> consultas() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Consulta c");
		List<Consulta> consultas = query.getResultList();
		for (Consulta consulta : consultas) {
			System.out.println("Paciente: " + consulta.getPaciente().getNome());
			System.out.println("Médico: " + consulta.getMedico().getNome());
			System.out.println("Data: " + consulta.getDataHora().toString());
			System.out.println("----------------------------------------------------");
		}
		this.factory.close();
		return consultas;
		
	} 
	
	public List<Consulta> buscarPorData(Date data_inicio, Date data_fim) {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Consulta c WHERE c.dataHora BETWEEN :data_inicio AND :data_fim");
		query.setParameter("data_inicio", data_inicio);
		query.setParameter("data_fim", data_fim);
		List<Consulta> consultas2 =  query.getResultList();
		for (Consulta consulta : consultas2) {
			System.out.println("Paciente: " + consulta.getPaciente().getNome());
			System.out.println("Médico: " + consulta.getMedico().getNome());
			System.out.println("Data: " + consulta.getDataHora().toString());
			System.out.println("----------------------------------------------------");
		}
		this.factory.close();
		return consultas2;
	}

}
