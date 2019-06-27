package br.com.consultemed.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "medicos")
@Entity
public class Medico {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome_medico")
	private String nome;
	@Column(name = "cpf_medico")
	private String cpf;
	@Column(name = "crm_medico")
	private String crm;
	@ManyToMany
	@JoinTable(name="medicoshorarios", joinColumns= {@JoinColumn(name="id_medico", referencedColumnName="id")}, inverseJoinColumns= {@JoinColumn(name="id_horario", referencedColumnName="id")})
	private List<Horario> horarios;
	@OneToMany(mappedBy="medico")
	private List<Agendamento> agendamentos;
	@OneToMany(mappedBy="medico")
	private List<Consulta> consultas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}
	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	
	

}
