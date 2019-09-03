package lab3;

import static junit.framework.Assert.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {

    private Agenda agenda1, agenda2;

    @BeforeEach
    void criarAgendas() {
        agenda1 = new Agenda("agenda 1");
        agenda2 = new Agenda("agenda 2");
    }


    @Test
    void testCadastrarContato() {
        Assertions.assertFalse(agenda1.cadastrarContato(0, "Charles", "Bezerra", "(84) 99924-3485"));
        Assertions.assertFalse(agenda1.cadastrarContato(1, "Charles", "Bezerra", ""));
        Assertions.assertFalse(agenda1.cadastrarContato(1, "Charles", "", "(84) 99924-3485"));
        Assertions.assertFalse(agenda1.cadastrarContato(1, "", "Bezerra", "(84) 99924-3485"));

        Assertions.assertTrue(agenda1.cadastrarContato(1, "Charles", "Bezerra", "(84) 99924-3485"));
        Assertions.assertTrue(agenda1.cadastrarContato(2, "Carlos", "Oliveira", "(83) 99933-3315"));
    }

    @Test
    void testListarContatos() {
        Assertions.assertEquals("1 Charles Bezerra\n2 Carlos Oliveira\n", agenda1.listarContatos());
    }

    @Test
    void testExibirContato() {

    }

    @Test
    void testToString() {

    }

    @Test
    void testEquals() {
    }
}