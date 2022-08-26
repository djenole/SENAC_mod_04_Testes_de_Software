package sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteSistemaBancario {

	static GerenciadoraClientes gerClientes;
	static GerenciadoraContas gerContas;

	public static void main(String[] args) {
		inicializaSistemaBancario(); //inicializar dados de contas e clientes

		Scanner sc = new Scanner(System.in);
		boolean continua = true;

		while(continua) {
			printMenu();

			int opcao = sc.nextInt();
			switch(opcao) {
			case 1:
				System.out.println("Digite o ID do cliente: ");
				int idCliente = sc.nextInt();
				Cliente cliente = gerClientes.pesquisaCliente(idCliente);

				if(cliente != null) {
					System.out.println(cliente.toString());
				} else {
					System.out.println("Cliente não encontrado!");
				}
				break;
				
			case 2:
				System.out.println("Digite o ID da conta:");
				int idConta = sc.nextInt();
				ContaCorrente conta = gerContas.pesquisaConta(idConta);
				
				if(conta != null) {
					System.out.println(conta.toString());
				} else {
					System.out.println("Conta não encontrada!");;
				}
				break;
			
			case 3:
				System.out.println("Digite o ID do cliente:");
				int idCliente2 = sc.nextInt();
				Cliente cliente2 = gerClientes.pesquisaCliente(idCliente2);
				
				if(cliente2 != null) {
					cliente2.setAtivo(true);
					System.out.println("Cliente ativado com sucesso!");
				} else {
					System.out.println("falha ao ativar o cliente");
				}
				break;
			
			case 4: 
				System.out.println("Digite o ID do cliente:");
				int idCliente3 = sc.nextInt();
				Cliente cliente3 = gerClientes.pesquisaCliente(idCliente3);
				
				if(cliente3 != null) {
					cliente3.setAtivo(false);
					System.out.println("Cliente desativado com sucesso!");
				} else {
					System.out.println("falha ao desativar o cliente");
				}
				break;
			
			case 5: 
				continua = false;
				System.out.println("************** Susta não, é Teste! ******************************");
				break;

			default:
				System.out.println("informação inválida!");
				break;
				
			}
		}		
		sc.close();
	}

	private static void printMenu() {
		System.out.println("Qual operação você deseja executar?");
		System.out.println("1) Consultar por um cliente.");
		System.out.println("2) Consultar por uma conta corrente.");
		System.out.println("3) Ativar um cliente.");
		System.out.println("4) Desativar um cliente.");
		System.out.println("5) Sair do sistema.");

	}

	private static void inicializaSistemaBancario() {
		// TODO Auto-generated method stub
		//criar lista vazia de contas e clientes;
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		List<Cliente> clientesDoBanco = new ArrayList<>();


		//criar e inserir duas contas
		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);

		/*

		//criar e inserir dois clientes do banco
		ContaCorrente cliente01 = new ContaCorrente(1, 0, true);
		ContaCorrente cliente02 = new ContaCorrente(2, 0, true);
		contasDoBanco.add(cliente01);
		contasDoBanco.add(cliente02);
		 */

		//criar e inserir dois cliente no banco
		Cliente cliente01 = new Cliente(1, "Gabriel", 30, "email@email.com",conta02.getId(), true);
		Cliente cliente02 = new Cliente(2, "Djenole", 29, "email@email.com", conta02.getId(), true);
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		gerContas = new GerenciadoraContas(contasDoBanco);

	}



}
