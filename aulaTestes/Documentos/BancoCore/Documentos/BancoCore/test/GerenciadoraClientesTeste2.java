import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import sistemabancario.Cliente;
import sistemabancario.GerenciadoraClientes;

public class GerenciadoraClientesTeste2 {

	private GerenciadoraClientes gerClientes;
	private int idCliente01 = 1;
	private int idCliente02 = 2;
	
	@Before
	public void setUp() {
		//montagem do cenário de teste
		
				Cliente cliente01 = new Cliente(idCliente01, "Clayton", 47, "clayton@gmail.com", 1 ,true);
				Cliente cliente02 = new Cliente(idCliente02, "Maria", 10, "maria@gmail.com", 1 ,true);
				
				List<Cliente> clientes = new ArrayList<>();
				clientes.add(cliente01);
				clientes.add(cliente02);
				
				gerClientes = new GerenciadoraClientes(clientes);
				
				//******************************************//
	}
	
	@After
	public void tearDown() {
		gerClientes.clear();
	}
	
	@Test
	public void testeRemoveCliente() {
		
		setUp();
		
				//fase de execução do teste
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);
		
		//análise do resultado esperado
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));
	}
	
	
	
	@Test
	public void testePesquisaCliente() {
	
		setUp();
		
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
