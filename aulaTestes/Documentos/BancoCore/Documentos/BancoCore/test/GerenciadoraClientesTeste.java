import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import sistemabancario.Cliente;
import sistemabancario.GerenciadoraClientes;

public class GerenciadoraClientesTeste {

	
	@Test
	public void testeRemoveCliente() {
		
		//montagem do cenário de teste
		int idCliente01 = 1;
		int idCliente02 = 2;
		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria", 10, "maria@gmail.com", 1 ,true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		//******************************************//
		//fase de execução do teste
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		//análise do resultado esperado
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
	}
	
	
	
	@Test
	public void testePesquisaCliente() {
		/*criando clientes para instaciar no caso de Teste*/
		int idCliente01 = 1;
		int idCliente02 = 2;
		
		Cliente cliente01 = new Cliente(idCliente01, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria", 10, "maria@gmail.com", 1 ,true);
		
		List <Cliente> clientes = new ArrayList();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
	
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);
		Cliente outroCliente = gerClientes.pesquisaCliente(idCliente02);
		
		assertThat(cliente.getId(), is(idCliente01));
		assertThat(cliente.getEmail(), is("clayton@gmail.com"));
		assertThat(cliente.getNome(), is("Clayton"));
		assertThat(cliente.getIdade(), is(47));
		
		
		assertThat(outroCliente.getId(), is(2));
		assertThat(outroCliente.getEmail(), is("maria@gmail.com"));
		assertThat(outroCliente.getNome(), is("Maria"));
		assertThat(outroCliente.getIdade(), is(10));
	}
	
	
	
	
}
