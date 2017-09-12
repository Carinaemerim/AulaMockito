package br.edu.ifrs.canoas.jee.maven;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class CarroTeste{
	
	private Carro renegade = mock(Carro.class);
	//dummy: esta sendo criado apenas para verificar o teste.
	
	
	@Test
	public void testeEhCarro(){
		 
		assertTrue(renegade instanceof Carro);
		//verifica se o renegade foi efetivamente criado para carros, se esta criando objetos corretamente
		//assertThat (renegade instaceof Carro).isTrue();
		
	}
	
	@Test
	public void testeComportamentoPadrao(){
		
		assertEquals ("O dublê deve retornar 0.0 para o método", 0.0, renegade.getTemperaturaMotor(), 0.0);
	}
	
	@Test
	public void testeStub(){
		
		assertEquals("A temperatura do motor é de zerograus.", 0.0, renegade.getTemperaturaMotor(), 0.0);
		
		when (renegade.getTemperaturaMotor()).thenReturn(200.00);
		//cria um duble para simular a temperatura do motor a 200 graus. STUB
		
		assertEquals ("A temperatura do motor é de duzentos graus.", 200.0, renegade.getTemperaturaMotor(), 0.0);
	}
	
	@Test(expected = RuntimeException.class)
	public void disparaExcecao(){
		
		when(renegade.precisaCombustivel()).thenThrow(new RuntimeException());
		renegade.precisaCombustivel();
	}
	
	@Test
	public void testeverificaArgumento(){
		
		renegade.dirigirPara("Canoas");
		renegade.precisaCombustivel();
		
		verify(renegade).precisaCombustivel();
		verify (renegade).dirigirPara("Canoas");
		
		//argumentos não podem ser diferentes.

	}
}
