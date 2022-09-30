import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sistemabancario.ContaCorrente;
import sistemabancario.GerenciadoraContas;

public class GerenciadoraContasTeste2 {


	private GerenciadoraContas gerContas;
	
	
	@Test
	public void testePesquisaConta() {
		int idConta01 = 1;
		int idConta02 = 2;
		
		ContaCorrente conta01 = new ContaCorrente(idConta01, 500, true );
		ContaCorrente conta02 = new ContaCorrente(idConta02, 944, false);
		
		List<ContaCorrente> contas = new ArrayList();
		
		contas.add(conta01);
		contas.add(conta02);
		
		gerContas = new GerenciadoraContas(contas);
		
		ContaCorrente conta = gerContas.pesquisaConta(1);
		
		assertThat(conta.getId(), is(idConta01));
		assertThat(conta.getSaldo(), is(500.0));
		assertThat(conta.isAtiva(), is(true));
	}
	
	@Test
	public void testTransfereValor() {
		
		//**************Montar o cenário****************\\
		
		ContaCorrente conta01 = new ContaCorrente(1, 100, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
		
		//***********************************************//
		
		//***** Execução de negocio selecionado para o teste****//
		boolean sucess = gerContas.transfereValor(1, 200, 2);
		//********************************************************//
		
		//******** Verificações e análise **********//
		assertTrue(sucess);
		assertThat(conta01.getSaldo(), is(-100.00));
		assertThat(conta02.getSaldo(), is(200.00));
		
		
		
		
		
	}
}
