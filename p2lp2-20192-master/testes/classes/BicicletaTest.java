package classes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BicicletaTest {
	private Bicicleta bicicleta1, bicicleta2;

	@BeforeEach
	void setUp() {
		bicicleta1 = new Bicicleta(10, "caloi");
		Assento a = new Assento(2, "gel");
		bicicleta2 = new Bicicleta(10, "caloi", a);
	}

	@Test
	void testBicicletaDoubleStringAssento() {
		String s = "Descricao: gel Tamanho: 2";
		assertEquals(s, bicicleta2.getAssento());
	}

	@Test
	void testBicicletaDoubleString() {
		assertEquals(10, bicicleta1.getVelocidadeMaxima(), 0.000001);
		assertEquals("caloi", bicicleta1.getModelo());
		assertEquals("", bicicleta1.getAssento());
		assertEquals(0, bicicleta1.getVelocidadeAtual(), 0.000001);
	}

	@Test
	public void testIgualdade(){
		//os dois objetos sao iguais
		//assertTrue(bicicleta1.igualdade(bicicleta2));
		
		//os dois objetos sao diferentes
		//Bicicleta bicicleta3 = new Bicicleta(11, "caloi");
		//assertFalse(bicicleta1.igualdade(bicicleta3));
		assertEquals(bicicleta1, bicicleta2);
		assertEquals(bicicleta1, bicicleta1);
		bicicleta1.equals(new String("livia"));
	}
	
	/*@Test
	void testGetAssento() {
		fail("Not yet implemented");
	}

	@Test
	void testAcelera() {
		fail("Not yet implemented");
	}

	@Test
	void testDesacelera() {
		fail("Not yet implemented");
	}

	@Test
	void testPara() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testSetAssento() {
		fail("Not yet implemented");
	}
*/
}
