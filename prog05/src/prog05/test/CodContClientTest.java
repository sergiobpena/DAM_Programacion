package prog05.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import prog05.CCC;

public class CodContClientTest {
	
	private int dc= 90 ;
	String numConta="3832312921" ;
	CCC cuenta;
	String cccString= "0305-0242-90-3832312921";
	String cccStringFalso= "035-0242-84-3832312921";
	String cccStringFalso2= "03a5-0242-84-3832312921";
	String cccStringFalso3= "0305-02b2-84-3832312921";
	String codOfi="0242";
	String codEnt="0305";
	String dcint="90";
	
	@Before
	public void antesque() {}
	
	@Test (expected = Exception.class)
	public void testConstructor() throws Exception {
		
		CCC c = new CCC(cccString);
	}

	@Test
	public void testValidaDc() {

		//CodContClien.separaDixitos(dcint)
		boolean isvalido =  CCC.validarDC(cccString );
	
		assertTrue(isvalido);
	}
	@Test
	public void testNonValidaDc() {

		
		boolean isvalido =  CCC.validarDC(cccStringFalso);
	
		assertFalse(isvalido);
	}
	@Test
	public void obterDixitosTacada() {
		int [] dcCalculado = CCC.obtenDixitoControl(cccString);
		int [] dcInserido = {9,0};
		
		assertArrayEquals(dcInserido, dcCalculado);
	}
	
	@Test 
	public void comprobaValidacion() {
		assertTrue(CCC.comprobaFormato(cccString));
	}
	
	@Test 
	public void comprobaValidacion2() {
		assertFalse(CCC.comprobaFormato(cccStringFalso3));
	}
}
