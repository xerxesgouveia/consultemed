package aula1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		boolean continua = true;
		InputStreamReader inputStr = new InputStreamReader( System.in );
		BufferedReader buf = new BufferedReader(inputStr);
		Atendente atendente = new Atendente();
		Collection<Atendente> atendentes = new ArrayList<Atendente>();
		while(continua == true) {
			System.out.println("Digite a op��o que deseja realizar:");
			System.out.println("1 - Cadastrar Usu�rio");
			System.out.println("2 - Listar Usu�rios");
			System.out.println("3 - Sair");
			String opcao = 	buf.readLine();
			
			if(opcao.equals("1")) {
				System.out.println("Digite o tipo da pessoa:");
				System.out.println("1 - Atendente");
				System.out.println("2 - T�cnico");
				String tipoPessoa = buf.readLine();
				if(tipoPessoa.equals("1")) {
					System.out.println("Digite o nome:");
					atendente.setNome(buf.readLine());
					System.out.println("Digite o telefone:");
					atendente.setTelefone(buf.readLine());
					
					atendente.salvar(atendente);
					continua = true;
					
				}
			}else if(opcao.equals("2")){
				
				
				atendentes = atendente.listar();
				
				for (Atendente a : atendentes) {
					System.out.println(a.getNome());
				}
				continua = true;
			}else if(opcao.equals("3")) {
				continua = false;
			}else {
				System.out.println("Op��o inv�lida!");
				continua = true;
			}
		}

	}

}
