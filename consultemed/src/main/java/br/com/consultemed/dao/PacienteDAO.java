/**
 * 
 */
package br.com.consultemed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Contato;
import br.com.consultemed.model.Paciente;
import br.com.consultemed.utils.JPAUtils;

/**
 * @author Xerxes
 *Classe responsável pelo acesso aos dados do banco
 */
public class PacienteDAO {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Paciente paciente) {
		factory.getTransaction().begin();
		factory.persist(paciente);
		factory.getTransaction().commit();
		factory.close();
	}
	
	public void remover(Long idContato) {
		this.factory.getTransaction().begin();
		this.factory.remove(buscarPorId(idContato));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Paciente buscarPorId(Long id) {
		this.factory.getTransaction().begin();
		Paciente pacienteRemover = this.factory.find(Paciente.class, id);
		return pacienteRemover;
	}
	
	public Paciente buscarPorNome(String nome) {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Paciente c WHERE c.nome = :nome");
		query.setParameter("nome", nome);
		Paciente paciente = (Paciente) query.getSingleResult();
		this.factory.close();
		return paciente;
	}
	
	public Paciente buscarPorEmail(String email) {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Paciente c WHERE c.email = :email");
		query.setParameter("email", email);
		Paciente paciente = (Paciente) query.getSingleResult();
		this.factory.close();
		return paciente;
	}
	
	public void editar(Paciente paciente) {
		this.factory.getTransaction().begin();
		Paciente pacienteEditar = buscarPorId(paciente.getId());
		pacienteEditar.setId(paciente.getId());
		pacienteEditar.setNome(paciente.getNome());
		pacienteEditar.setEmail(paciente.getEmail());
		pacienteEditar.setCpf(paciente.getCpf());
		pacienteEditar.setNumeroCadastro(paciente.getNumeroCadastro());
		
		this.factory.merge(pacienteEditar);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Paciente> pacientes() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Paciente c");
		List<Paciente> pacientes = query.getResultList();
		for (Paciente paciente : pacientes) {
			System.out.println("Nome: "+paciente.getNome());
			System.out.println("Email: "+paciente.getEmail());
			System.out.println("Número de cadastro: "+paciente.getNumeroCadastro());
			System.out.println("----------------------------------------------------");
		}
		this.factory.close();
		return pacientes;
		
	} 

}
