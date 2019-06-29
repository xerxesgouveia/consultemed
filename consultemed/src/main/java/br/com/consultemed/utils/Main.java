package br.com.consultemed.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Consulta;
import br.com.consultemed.model.Contato;
import br.com.consultemed.model.Horario;
import br.com.consultemed.model.Medico;
import br.com.consultemed.model.Paciente;
import br.com.consultemed.service.AgendamentoService;
import br.com.consultemed.service.ConsultaService;
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
			System.out.println("6 - Agendar uma consulta");
			System.out.println("7 - Listar agendamentos");
			System.out.println("8 - Cadastrar consulta");
			System.out.println("9 - Listar consultas");
			System.out.println("10 - Listar consultas por data");
			System.out.println("11 - Remover agendamento");
			System.out.println("12 - Cancelar consulta");
			
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
			case "6":
				PacienteService pacienteService4 = new PacienteService();
				MedicoService medicoService2 = new MedicoService();
				AgendamentoService agendamentoService = new AgendamentoService();
				Agendamento agendamento = new Agendamento();
				
				System.out.println("Digite o nome do paciente");
				agendamento.setPaciente(pacienteService4.buscaPacienteNome(buf.readLine()));
				System.out.println("Digite o nome do médico");
				agendamento.setMedico(medicoService2.buscaMedicoNome(buf.readLine()));
				System.out.println("Digite a data do agendamento no formato dd/mm/aaaa");
				String dataAgendamento = buf.readLine();
				agendamento.setDataHora(new SimpleDateFormat("dd/MM/yyyy").parse(dataAgendamento));
				int validaAgendamento = agendamentoService.validaAgendamento(agendamento);
				if(validaAgendamento==1) {
					System.out.println("Não é possível agendar para uma data retroativa!");
				}else {

					agendamentoService.salvar(agendamento);
				}
				break;
			case "7":
				AgendamentoService agendamentoService2 = new AgendamentoService();
				agendamentoService2.listar();
				break;
			case "8":
				PacienteService pacienteService5 = new PacienteService();
				MedicoService medicoService3 = new MedicoService();
				ConsultaService consultaService = new ConsultaService();
				Consulta consulta = new Consulta();
				
				System.out.println("Digite o nome do paciente");
				consulta.setPaciente(pacienteService5.buscaPacienteNome(buf.readLine()));
				System.out.println("Digite o nome do médico");
				consulta.setMedico(medicoService3.buscaMedicoNome(buf.readLine()));
				
				LocalDateTime agora1 = LocalDateTime.now();

				DateTimeFormatter formatterData1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String dataFormatada1 = formatterData1.format(agora1);
				consulta.setDataHora(new SimpleDateFormat("dd/MM/yyyy").parse(dataFormatada1));
				consultaService.salvar(consulta);
				
				break;
			case "9":
				ConsultaService consultaService2 = new ConsultaService();
				consultaService2.listar();
				break;
			case "10":
				ConsultaService consultaService3 = new ConsultaService();
				System.out.println("Digite a data inicial");
				String data_inicio = buf.readLine();
				Date data_inicial = new SimpleDateFormat("dd/MM/yyyy").parse(data_inicio);
				System.out.println("Digite a data final");
				String data_fim = buf.readLine();
				Date data_final = new SimpleDateFormat("dd/MM/yyyy").parse(data_fim);
				consultaService3.buscaPorData(data_inicial, data_final);
				break;
			case "11":
				AgendamentoService agendamentoService3 = new AgendamentoService();
				System.out.println("Digite o código do agendamento");
				agendamentoService3.remover(Long.parseLong(buf.readLine()));
				System.out.println("Agendamento removido!");
				break;
			case "12":
				ConsultaService consultaService4 = new ConsultaService();
				AgendamentoService agendamentoService4 = new AgendamentoService();
				PacienteService pacienteService6 = new PacienteService();
				MedicoService medicoService4 = new MedicoService();
				System.out.println("Digite o código da consulta");
				consultaService4.remover(Long.parseLong(buf.readLine()));
				System.out.println("Consulta removida!");
				System.out.println("Deseja reagendar? 1 - Sim 2 - Não");
				String opcaoReagendar = buf.readLine();
				if(opcaoReagendar.equals("1")) {
					Agendamento reagendamento = new Agendamento();
					
					System.out.println("Digite o nome do paciente");
					reagendamento.setPaciente(pacienteService6.buscaPacienteNome(buf.readLine()));
					System.out.println("Digite o nome do médico");
					reagendamento.setMedico(medicoService4.buscaMedicoNome(buf.readLine()));
					System.out.println("Digite a data do agendamento no formato dd/mm/aaaa");
					String dataReagendamento = buf.readLine();
					reagendamento.setDataHora(new SimpleDateFormat("dd/MM/yyyy").parse(dataReagendamento));
					int validaReagendamento = agendamentoService4.validaAgendamento(reagendamento);
					if(validaReagendamento==1) {
						System.out.println("Não é possível agendar para uma data retroativa!");
					}else {

						agendamentoService4.salvar(reagendamento);
					}	
				}
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		}
		
		

	}

}
