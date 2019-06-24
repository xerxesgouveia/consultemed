package br.com.consultemed.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.consultemed.model.Contato;
import br.com.consultemed.model.Horario;
import br.com.consultemed.model.Medico;
import br.com.consultemed.model.Paciente;
import br.com.consultemed.service.ContatoService;
import br.com.consultemed.service.HorarioService;
import br.com.consultemed.service.MedicoService;
import br.com.consultemed.service.PacienteService;

public class Main {

	public static void main(String[] args) throws IOException, ParseException {
		
		
		boolean continua = true;
		
		InputStreamReader inputStr = new InputStreamReader( System.in );
		BufferedReader buf = new BufferedReader(inputStr);
		
		
		while(continua == true) {
			System.out.println("Digite a opção que deseja realizar:");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar Paciente");
			System.out.println("2 - Listar Pacientes");
			System.out.println("3 - Cadastrar Contato");
			System.out.println("4 - Listar Contatos");
			System.out.println("5 - Cadastrar Médico");
			
			String opcao = 	buf.readLine();
			switch (opcao) {
			case "0":
				continua = false;
				break;
			case "1":
				PacienteService pacienteService = new PacienteService();
				Paciente paciente = new Paciente();
				System.out.println("Digite o nome do paciente");
				paciente.setNome(buf.readLine());
				System.out.println("Digite o CPF do paciente");
				paciente.setCpf(buf.readLine());
				System.out.println("Digite o número de cadastro do paciente");
				paciente.setNumeroCadastro(buf.readLine());
				System.out.println("Digite o e-mail do paciente");
				paciente.setEmail(buf.readLine());
				pacienteService.salvar(paciente);
				break;
				
			case "2":
				PacienteService pacienteService2 = new PacienteService();
				pacienteService2.listar();
				break;
			case "3":
				PacienteService pacienteService3 = new PacienteService();
				ContatoService contatoService = new ContatoService();
				Contato contato = new Contato();
				System.out.println("Digite o nome do paciente do contato");
				contato.setPaciente(pacienteService3.buscaPacienteNome(buf.readLine()));
				System.out.println("Digite o nome do contato");
				contato.setNome(buf.readLine());
				System.out.println("Digite o e-mail do contato");
				contato.setEmail(buf.readLine());
				System.out.println("Digite o telefone do contato");
				contato.setTelefone(buf.readLine());
				contatoService.salvar(contato);
				break;
			case "4":
				ContatoService contatoService2 = new ContatoService();
				contatoService2.listar();
				break;
			case "5":
				MedicoService medicoService = new MedicoService();
				HorarioService horarioService = new HorarioService();
				Medico medico = new Medico();
				List<Horario> horarios = new ArrayList<Horario>();
				System.out.println("Digite o nome do médico");
				medico.setNome(buf.readLine());
				System.out.println("Digite o CPF do médico");
				medico.setCpf(buf.readLine());
				System.out.println("Digite o CRM do médico");
				medico.setCrm(buf.readLine());
				boolean checkHorarios = true;
				while(checkHorarios == true) {
					Horario horario = new Horario();
					System.out.println("Digite a data no formato dd/mm/aaaa");
					String data = buf.readLine();
					horario.setData(new SimpleDateFormat("dd/MM/yyyy").parse(data));
					horarios.add(horario);
					horarioService.salvar(horario);
					System.out.println("Deseja cadastrar mais algum horário? 1 - SIM 2 - NÃO");
					String option = buf.readLine();
					if(option.equals("1")) {
						checkHorarios = true;
					}else {
						checkHorarios = false;
					}
				}
				medico.setHorarios(horarios);
				medicoService.salvar(medico);
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
		
		

	}

}
