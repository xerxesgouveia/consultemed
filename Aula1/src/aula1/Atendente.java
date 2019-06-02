package aula1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Atendente extends Pessoa implements CRUDAtendente {


	private List<Atendente> atendentes;
	
	public Atendente() {
		// TODO Auto-generated constructor stub
		if(atendentes == null) {
			atendentes = new ArrayList<Atendente>();
		}
	}
	
	@Override
	public void fazerAnivesario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvar(Atendente item) {
		// TODO Auto-generated method stub
		atendentes.add(item);
		
	}

	@Override
	public List<Atendente> listar() {
		// TODO Auto-generated method stub
		return atendentes;
	}

	@Override
	public void remover(Atendente item) {
		// TODO Auto-generated method stub
		atendentes.remove(item);
		
	}

	@Override
	public void atendeOs() {
		// TODO Auto-generated method stub
		
	}

	
}
