package lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AgendaTest {

    private Agenda agenda1, agenda2, agenda3, agenda4;


    @BeforeEach
    void criarAgendas() {
        agenda1 = new Agenda("agenda 1");
        agenda2 = new Agenda("agenda 2");
        agenda3 = new Agenda("agenda 3");
        agenda4 = new Agenda();

        //Agenda 1
            agenda1.cadastrarContato(1, "Charles", "Bezerra", "(84) 99924-3485");
            agenda1.cadastrarContato(2, "Carlos", "Oliveira", "(83) 99933-3315");
        //Agenda 2
            agenda2.cadastrarContato(1, "Charles", "Bezerra", "(84) 99924-3485");
            agenda2.cadastrarContato(2, "Carlos", "Oliveira", "(83) 99933-3315");
        //Agenda 3
            agenda3.cadastrarContato(1, "Charles", "Bezerra", "(84) 99924-3485");
            agenda3.cadastrarContato(2, "Carlos", "Oliveira", "(85) 99999-9999");
            agenda3.cadastrarContato(3, "Pedro", "Henrique", "(85) 99999-9999");
        //Agenda 4
            //Vazio
    }


    @Test
    void testCadastrarContato() {
        assertFalse( agenda1.cadastrarContato(0, "Charles", "Bezerra", "(84) 99924-3485") );
        assertFalse( agenda1.cadastrarContato(1, "Pedro", "Henrique", "") );
        assertFalse( agenda1.cadastrarContato(1, "Nathanael", "", "(84) 99924-3485") );
        assertFalse( agenda1.cadastrarContato(1, "", "Bezerra", "(84) 99924-3485") );

        assertTrue( agenda1.cadastrarContato(1, "Charles", "Bezerra", "(84) 99924-3485") );
        assertTrue( agenda1.cadastrarContato(100, "Carlos", "Oliveira", "(83) 99933-3315") );
        assertFalse( agenda1.cadastrarContato(101, "Pedro", "Henrique", "(83) 99999-9999") );
    }

    @Test
    void testListarContatos() {
        assertEquals("1 Charles Bezerra\n2 Carlos Oliveira\n", agenda1.listarContatos());
        assertEquals("1 Charles Bezerra\n2 Carlos Oliveira\n", agenda2.listarContatos());
        assertEquals("1 Charles Bezerra\n2 Carlos Oliveira\n3 Pedro Henrique\n", agenda3.listarContatos());
        assertEquals("", agenda4.listarContatos());
    }

    @Test
    void testExibirContato() {

        //Agenda 1
        assertEquals("1 Charles Bezerra - (84) 99924-3485", agenda1.exibirContato(1));
        assertEquals("2 Carlos Oliveira - (83) 99933-3315", agenda1.exibirContato(2));

        //Agenda 2
        assertEquals("1 Charles Bezerra - (84) 99924-3485", agenda2.exibirContato(1));
        assertEquals("2 Carlos Oliveira - (83) 99933-3315", agenda2.exibirContato(2));

        //Agenda 3
        assertEquals("1 Charles Bezerra - (84) 99924-3485", agenda3.exibirContato(1));
        assertEquals("2 Carlos Oliveira - (83) 99933-3315", agenda3.exibirContato(2));
        assertEquals("3 Pedro Henrique - (84) 99924-3485", agenda3.exibirContato(1));
    }

    @Test
    void testEquals() {
        assertTrue(agenda1.equals(agenda2));
        assertTrue(agenda2.equals(agenda2));

        assertFalse(agenda1.equals(agenda3));
        assertFalse(agenda3.equals(agenda1));

        assertFalse(agenda1.equals(agenda4));
        assertFalse(agenda4.equals(agenda1));

        assertFalse(agenda2.equals(agenda3));
        assertFalse(agenda3.equals(agenda2));

        assertFalse(agenda2.equals(agenda4));
        assertFalse(agenda4.equals(agenda2));

        assertFalse(agenda3.equals(agenda4));
        assertFalse(agenda4.equals(agenda3));

    }
}