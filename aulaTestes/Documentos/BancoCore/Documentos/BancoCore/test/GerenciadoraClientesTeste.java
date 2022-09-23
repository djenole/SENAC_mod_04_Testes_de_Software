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
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		Cliente cliente02 = new Cliente(2, "Maria", 10, "maria@gmail.com", 1 ,true);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
		
		//******************************************//
		//fase de execução do teste
		boolean clienteRemovido = gerClientes.removeCliente(2);
		
		//análise do resultado esperado
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
	}
	
	
	
	@Test
	public void testePesquisaCliente() {
		/*criando clientes para instaciar no caso de Teste*/
		
		Cliente cliente01 = new Cliente(1, "Clayton", 47, "clayton@gmail.com", 1 ,true);
		Cliente cliente02 = new Cliente(2, "Maria", 10, "maria@gmail.com", 1 ,true);
		
		List <Cliente> clientes = new ArrayList();
		clientes.add(cliente01);
		clientes.add(cliente02);
		
		GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientes);
	
		Cliente cliente = gerClientes.pesquisaCliente(1);
		Cliente outroCliente = gerClientes.pesquisaCliente(2);
		
		assertThat(cliente.getId(), is(1));
		assertThat(cliente.getEmail(), is("clayton@gmail.com"));
		assertThat(cliente.getNome(), is("Clayton"));
		assertThat(cliente.getIdade(), is(47));
		
		
		assertThat(outroCliente.getId(), is(2));
		assertThat(outroCliente.getEmail(), is("maria@gmail.com"));
		assertThat(outroCliente.getNome(), is("Maria"));
		assertThat(outroCliente.getIdade(), is(10));
	}
	
	
	
	
}
