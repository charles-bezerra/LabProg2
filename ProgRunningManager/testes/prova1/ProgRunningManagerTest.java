package prova1;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgRunningManagerTest {

	private ProgRunningManager running;
	
	@BeforeEach
	void criarClasse() {
		running = new ProgRunningManager();
		running.cadastrarCorrida("Corrida 1", "00/00/00", 30);
		running.cadastrarCorrida("Corrida 2", "00/00/00", 31);
		
		running.cadastrarChipCorrida("Corrida 1");
		running.cadastrarChipCorrida("Corrida 1");
		
		running.cadastrarChipCorrida("Corrida 2");
		running.cadastrarChipCorrida("Corrida 2");		
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void testContarChipsCorrida() {
		running.cadastrarChipCorrida("Corrida 1");
		running.cadastrarChipCorrida("Corrida 1");
		assertEquals(2, running.contarChipsCorrida("Corrida 1"));
	}
	
	@Test
	void testExibirCorredor() {
		running.atualizaChipDistanciaTempo("Corrida 1", 0, 10, 100);
		assertEquals("0 - 10km - 100min", running.exibirCorredor("Corrida 1", 0) );
	}
	
	
	
	
}
