package aula1;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa implements CRUDTecnico {
	
	private String matricula;
	private List<Tecnico> tecnicos = new ArrayList<Tecnico>();

	@Override
	public void salvar(Tecnico item) {
		// TODO Auto-generated method stub
		tecnicos.add(item);
	}
	
	@Override
	public List<Tecnico> listar() {
		// TODO Auto-generated method stub
		return tecnicos;
	}
	
	@Override
	public void remover(Tecnico item) {
		// TODO Auto-generated method stub
		tecnicos.remove(item);
		
	}
	
	@Override
	public void atendeOs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fazerAnivesario() {
		// TODO Auto-generated method stub
		
	}

	
	

}
