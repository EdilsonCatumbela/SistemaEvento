package Eventos;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastrarEvento {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		
		/*ArrayList<Convidado> convidados = new ArrayList<Convidado>();
		CriarConvidadosDinamicamente(5, convidados);*/
		
		ArrayList<Evento> lista = new ArrayList<Evento>();
		/*System.out.println("Informe a quantidade de eventos a ser cadastrado");
		int qdt;
		qdt = scan.nextInt();
		criarEventosDinamicamente(qdt, lista);
		scan.nextLine();*/
		int opcao = 1;

		while (opcao != 0) {

			opcao = obterOpcaoMenu(scan);

			switch (opcao) {
			case 1:
				adicionarEventoFinal(scan, lista);
				break;
			case 2:
				adicionarEventoPosicao(scan, lista);
				break;
			case 3:
				obtemEventoPosicao(scan, lista);
				break;
			case 4:
				obtemEvento(scan, lista);
				break;
			case 5:
				pesquisarUltimoIndice(scan, lista);
				break;
			case 6:
				pesquisarEventoExiste(scan, lista);
				break;
			case 7:
				excluirPorPosicao(scan, lista);
				break;
			case 8:
				excluirEvento(scan, lista);
				break;
			case 9:
				imprimeTamanhoVetor(lista);
				break;
			case 10:
				limparVetor(lista);
				break;
			case 11:
				imprimirVetor(lista);
				break;
			default:
				break;
			}
		}

		System.out.println("Usuário digitou 0, programa terminado");
	}

	protected static int obterOpcaoMenu(Scanner scan) {

		boolean entradaValida = false;
		int opcao = 0;
		String entrada;

		while (!entradaValida) {

			System.out.println("\nDigite a opção desejada:");
			System.out.println("1: Cadastrar Evento");
			System.out
					.println("2: Editar Evento");
			System.out
					.println("3: Consultar um evento de uma posição específica");
			System.out.println("4: Consultar evento");
			System.out.println("5: Consulta último índide do evento");
			System.out.println("6: Verifica se o evento existe");
			System.out.println("7: Excluir por posição");
			System.out.println("8: Excluir evento");
			System.out.println("9: Verifica tamanho da lista");
			System.out.println("10: Excluir todos os evento da lista");
			System.out.println("11: Relatório");
			System.out.println("0: Sair\n\n");

			try {

				entrada = scan.nextLine();
				opcao = Integer.parseInt(entrada);

				if (opcao >= 0 && opcao <= 11) {
					entradaValida = true;
				} else {
					throw new Exception();
				}

			} catch (Exception e) {

				System.out.println("Entrada inválida, digite novamente\n\n");
			}
		}

		return opcao;
	}

	protected static String leInformacao(String msg, Scanner scan) {

		System.out.println(msg);
		String entrada = scan.nextLine();

		return entrada;
	}

	protected static int leInformacaoInt(String msg, Scanner scan) {

		boolean entradaValida = false;
		int num = 0;

		while (!entradaValida) {

			try {

				System.out.println(msg);
				String entrada = scan.nextLine();

				num = Integer.parseInt(entrada);

				entradaValida = true;

			} catch (Exception e) {
				System.out.println("Entrada inválida, digite novamente");
			}
		}

		return num;
	}

	private static void adicionarEventoFinal(Scanner scan,
			ArrayList<Evento> lista) {

		System.out.println("Criando um evento, entre com as informações:");
		String nome = leInformacao("Entre com o nome do evento", scan);
		String data = leInformacao("Entre com a data do evento", scan);
		String horario = leInformacao("Entre com o horário do evento", scan);

		String nomeRua = leInformacao("Entre com o nome da rua", scan);
		String numero = leInformacao("Entre com o numero da casa", scan);
		String complemento = leInformacao("Entre com o complemento", scan);
		String cep = leInformacao("Entre com o cep", scan);
		String cidade = leInformacao("Entre com o cidade", scan);
		String estado = leInformacao("Entre com o estado", scan);

		String nomeConvidado = leInformacao("Entre com o nome do convidado",
				scan);
		String rg = leInformacao("Entre com o rg do convidado", scan);

		Convidado convidado = new Convidado(rg, nomeConvidado);
		ArrayList<Convidado> convidados = new ArrayList<Convidado>(5);
		convidados.add(convidado);

		Endereco endereco = new Endereco(nomeRua, numero, complemento, cep,
				cidade, estado);

		Evento evento = new Evento(nome, endereco, data, horario, convidados);

		evento.setEndereco(endereco);
		evento.setConvidados(convidados);
		lista.add(evento);

		System.out.println("Evento adicionado com sucesso!");
		System.out.println(evento);
	}

	private static void adicionarEventoPosicao(Scanner scan,
			ArrayList<Evento> lista) {

		System.out.println("Criando um evento, entre com as informações:");
		String nome = leInformacao("Entre com o nome do evento", scan);
		String data = leInformacao("Entre com a data do evento", scan);
		String horario = leInformacao("Entre com o horário do evento", scan);

		String nomeRua = leInformacao("Entre com o nome da rua", scan);
		String numero = leInformacao("Entre com o numero da casa", scan);
		String complemento = leInformacao("Entre com o complemento", scan);
		String cep = leInformacao("Entre com o cep", scan);
		String cidade = leInformacao("Entre com o cidade", scan);
		String estado = leInformacao("Entre com o estado", scan);

		String nomeConvidado = leInformacao("Entre com o nome do convidado",
				scan);
		String rg = leInformacao("Entre com o rg do convidado", scan);

		Endereco endereco = new Endereco(nomeRua, numero, complemento, cep,
				cidade, estado);

		Convidado convidado = new Convidado(rg, nomeConvidado);
		ArrayList<Convidado> convidados = new ArrayList<Convidado>(5);
		convidados.add(convidado);

		Evento evento = new Evento(nome, endereco, data, horario, convidados);

		evento.setEndereco(endereco);
		evento.setConvidados(convidados);

		int pos = leInformacaoInt("Entre com a posição a adicionar o evento",
				scan);

		try {
			lista.add(pos, evento);

			System.out.println("Evento adicionado com sucesso!");
			System.out.println(evento);

		} catch (Exception e) {
			System.out.println("Posição inválida, evento não adicionado");
		}

	}

	private static void obtemEvento(Scanner scan, ArrayList<Evento> lista) {

		int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);
		System.out.println();
		try {

			Evento evento = lista.get(pos);

			System.out.println("Evento existe, seguem dados:");
			System.out.println(evento);

			System.out.println("Fazendo pesquisa do evento encontrado:");
			pos = lista.indexOf(evento);

			System.out.println("Evento encontrado na posição " + pos);

		} catch (Exception e) {
			System.out.println("Posição inválida!");
		}
	}

	private static void obtemEventoPosicao(Scanner scan, ArrayList<Evento> lista) {

		int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try {

			Evento evento = lista.get(pos);

			System.out.println("Evento existe, seguem dados:");
			System.out.println(evento);

		} catch (Exception e) {
			System.out.println("Posição inválida");
		}
	}

	private static void pesquisarUltimoIndice(Scanner scan,
			ArrayList<Evento> lista) {

		int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try {

			Evento evento = lista.get(pos);

			System.out.println("Evento existe, seguem dados:");
			System.out.println(evento);

			System.out
					.println("Fazendo pesquisa do último índice do evento encontrado:");
			pos = lista.lastIndexOf(evento);

			System.out.println("Evento encontrado na posição " + pos);

		} catch (Exception e) {
			System.out.println("Posição inválida!");
		}
	}

	private static void pesquisarEventoExiste(Scanner scan,
			ArrayList<Evento> lista) {

		int pos = leInformacaoInt("Entre com a posição a ser pesquisada", scan);

		try {

			Evento evento = lista.get(pos);

			boolean existe = lista.contains(evento);

			if (existe) {
				System.out.println("Evento existe, seguem dados:");
				System.out.println(evento);
			} else {
				System.out.println("Evento não existe");
			}

		} catch (Exception e) {
			System.out.println("Posição inválida!");
		}
	}

	private static void excluirPorPosicao(Scanner scan, ArrayList<Evento> lista) {
		int pos = leInformacaoInt("Entre com a posição a ser removida", scan);

		try {

			lista.remove(pos);

			System.out.println("Evento excluido");

		} catch (Exception e) {
			System.out.println("Posição inválida!");
		}
	}

	private static void excluirEvento(Scanner scan, ArrayList<Evento> lista) {
		int pos = leInformacaoInt("Entre com a posição a ser removida", scan);

		try {

			Evento contato = lista.get(pos);

			lista.remove(contato);

			System.out.println("Evento excluido");

		} catch (Exception e) {
			System.out.println("Posição inválida!");
		}
	}

	private static void imprimeTamanhoVetor(ArrayList<Evento> lista) {

		System.out.println("Tamanho do vetor é de: " + lista.size());
	}

	/*private static void cadastrarConvidado(Scanner scan,
			ArrayList<Convidado> lista) {
		String nomeConvidado = leInformacao("Entre com o nome do convidado",
				scan);
		String rg = leInformacao("Entre com o rg do convidado", scan);

		Convidado convidado = new Convidado(rg, nomeConvidado);
		ArrayList<Convidado> convidados = new ArrayList<Convidado>(5);
		convidados.add(convidado);
	}*/

	private static void limparVetor(ArrayList<Evento> lista) {

		lista.clear();

		System.out.println("Todos os contatos do vetor foram excluidos");
	}

	protected static void criarEventosDinamicamente(int qtd,
			ArrayList<Evento> lista) {
		Evento evento;
		Endereco endereco;
		Convidado convidado;
		ArrayList<Convidado> convidados;

		for (int i = 1; i <= qtd; i++) {
			evento = new Evento();
			endereco = new Endereco();
			convidado = new Convidado();
			convidados = new ArrayList<Convidado>(5);

			evento.setNome("vazio");
			evento.setData("vazio");
			evento.setHorario("vazio");

			convidado.setNomeConvidado("vazio");
			convidado.setRg("vazio");
			convidados.add(convidado);
			evento.setConvidados(convidados);

			endereco.setNomeRua("vazio");
			endereco.setNumero("vazio");
			endereco.setComplemento("vazio");
			endereco.setCep("vazio");
			endereco.setCidade("vazio");
			endereco.setEstado("vazio");

			evento.setEndereco(endereco);

			lista.add(evento);

		}

	}

	/*protected static void CriarConvidadosDinamicamente(int qtd,
			ArrayList<Convidado> convidados) {
		Convidado convidado;

		for (int i = 1; i < qtd; i++) {
			convidado = new Convidado();
			convidado.setNomeConvidado("vazio");
			convidado.setRg("vazio");
			convidados.add(convidado);
		}
	}*/

	private static void imprimirVetor(ArrayList<Evento> lista) {

		System.out.println(lista);
	}
	
	/*private static void imprimirConvidado(ArrayList<Convidado> convidados) {

		System.out.println(convidados);
	}*/
}
