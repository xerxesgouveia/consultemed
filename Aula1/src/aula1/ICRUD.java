package aula1;

import java.util.List;

public interface ICRUD <T> {
	
	public void salvar(T item);
	public List<T> listar();
	public void remover(T item);
	public void atendeOs();

}
