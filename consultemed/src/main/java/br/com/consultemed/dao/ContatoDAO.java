/**
 * 
 */
package br.com.consultemed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Contato;
import br.com.consultemed.utils.JPAUtils;

/**
 * @author Xerxes
 *Classe responsável pelo acesso aos dados do banco
 */
public class ContatoDAO {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Contato contato) {
		factory.getTransaction().begin();
		factory.persist(contato);
		factory.getTransaction().commit();
		factory.close();
	}
	
	public void remover(Long idContato) {
		this.factory.getTransaction().begin();
		this.factory.remove(buscarPorId(idContato));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Contato buscarPorId(Long id) {
		this.factory.getTransaction().begin();
		Contato contatoRemover = this.factory.find(Contato.class, id);
		return contatoRemover;
	}
	
	public Contato buscarPorNome(String nome) {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Contato c WHERE c.nome = :nome");
		query.setParameter("nome", nome);
		Contato contato = (Contato) query.getSingleResult();
		this.factory.close();
		return contato;
	}
	
	public Contato buscarPorEmail(String email) {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Contato c WHERE c.email = :email");
		query.setParameter("email", email);
		Contato contato = (Contato) query.getSingleResult();
		this.factory.close();
		return contato;
	}
	
	public void editar(Contato contato) {
		this.factory.getTransaction().begin();
		Contato contatoEditar = buscarPorId(contato.getId());
		contatoEditar.setId(contato.getId());
		contatoEditar.setNome(contato.getNome());
		contatoEditar.setEmail(contato.getEmail());
		contatoEditar.setTelefone(contato.getTelefone());
		
		this.factory.merge(contatoEditar);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Contato> contatos() {
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT c FROM Contato c");
		List<Contato> contatos = query.getResultList();
		for (Contato contato : contatos) {
			System.out.println("Nome do contato: " + contato.getNome());
			System.out.println("Email do contato: " + contato.getEmail());
			System.out.println("Telefone do contato: " + contato.getTelefone());
			System.out.println("----------------------------------------------------");
		}
		this.factory.close();
		return contatos;
		
	} 

}
