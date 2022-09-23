import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sistemabancario.ContaCorrente;
import sistemabancario.GerenciadoraContas;

public class GerenciadoraContasTeste {

	
	@Test
	public void testePesquisaConta() {
		
		ContaCorrente conta01 = new ContaCorrente(1, 500, true );
		ContaCorrente conta02 = new ContaCorrente(2, 944, false);
		
		List<ContaCorrente> contas = new ArrayList();
		
		contas.add(conta01);
		contas.add(conta02);
		
		GerenciadoraContas gerContas = new GerenciadoraContas(contas);
		
		ContaCorrente conta = gerContas.pesquisaConta(1);
		
		assertThat(conta.getId(), is(1));
		assertThat(conta.getSaldo(), is(500.0));
		assertThat(conta.isAtiva(), is(true));
	}
}
