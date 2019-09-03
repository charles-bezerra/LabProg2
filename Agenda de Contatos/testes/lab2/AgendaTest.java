package lab2;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {

	private Agenda agenda1, agenda2;

	@BeforeEach
    void setUp(){
	    agenda1 = new Agenda("agenda 1");
	    agenda2 = new Agenda("agenda 2");
    }

    @Test
    void testListarContatos() {
    }

    @Test
    void testCadastrarContato() {
        assertEquals( agenda1.cadastrarContato(null ,"Charles","Bezerra","(84) 99924-3485"), false );
        assertEquals( agenda1.cadastrarContato(1,"Charles","Bezerra",null), false );
        assertEquals( agenda1.cadastrarContato(1,"Charles",null,"(84) 99924-3485"), false );
        assertEquals( agenda1.cadastrarContato(1 ,null,"Bezerra","(84) 99924-3485"), false );

        assertEquals( agenda1.cadastrarContato(1,"Charles","Bezerra","(84) 99924-3485"), true );
        assertEquals( agenda1.cadastrarContato(2,"Carlos","Oliveira","(83) 99933-3315"), true );
    }

    @Test
    void testExibirContato() {
        assertEquals( agenda1.exibirContatos(), "1 Charles Bezerra (84) 99924-3485\n2 Carlos Oliveira (83) 99933-3315\n");
    }

    @Test
    void testExibirContatos() {

	}

    @Test
    void testToString() {
    	
    }
    
    @Test
    void testEquals() {
    }
}