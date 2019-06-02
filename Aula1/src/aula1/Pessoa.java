package aula1;

public abstract class Pessoa {
	
	private String nome;
	private String telefone;
	
	public abstract void fazerAnivesario();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
