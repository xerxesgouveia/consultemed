/**
 * 
 */
package br.com.consultemed.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Xerxes
 *
 */

@Table(name = "pacientes")
@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome_paciente")
	private String nome;
	@Column(name = "cpf_paciente")
	private String cpf;
	@Column(name = "numeroCadastro_paciente")
	private String numeroCadastro;
	@Column(name = "email_paciente")
	private String email;
	@OneToMany(mappedBy="paciente")
	private List<Contato> contatos;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroCadastro() {
		return numeroCadastro;
	}
	public void setNumeroCadastro(String numeroCadastro) {
		this.numeroCadastro = numeroCadastro;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public List<Contato> getContatos() {
		return contatos;
	}
	
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
}
