package prog05.test;

import static org.junit.Assert.*;

import org.junit.Test;

import prog05.Nome;
import prog05.exceptions.NomeException;

public class NomeTest {
	String nome1="Pepito dos palotes y  la madre que lo pario";
	String nome2="Sergio Botana Pena";
			
	@Test(expected = NomeException.class)
	public void testContructor() throws NomeException  {
		Nome nome= new Nome(nome1);
	}
	
	@Test(expected = NomeException.class)
	public void testSetNomeFail() throws Exception {
		Nome nome= new Nome(nome2);
		nome.setNome(nome1);
	}
	
	@Test
	public void testSetNome() throws Exception {
		Nome nome= new Nome(nome2);
		nome.setNome("Pepito palotes");
		
		assertEquals(nome.getNome(),"Pepito palotes");
	}

}
