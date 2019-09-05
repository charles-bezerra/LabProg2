package lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Classe  que contém os testes de Contato
 *
 * @author Charles Bezerra de Oliveira Júnior-119110595 (Lab3)
 *  */
class ContatoTest{

    /**
     * Atributos do tipo contato.
     * */
    private Contato contato1, contato2, contato3, contato4;

    /**
     * Método que inicializa e atribui objetos do tipo Contato
     * */
    @BeforeEach
    void criarContatos(){
        contato1 = new Contato("Charles","Bezerra", "(84) 99999-9999");
        contato2 = new Contato("Pedro","Castanha", "(84) 99999-9999");
        contato3 = new Contato("Charles","Bezerra", "(84) 99999-9999");
        contato4 = new Contato("Matheus","Oliveira", "(84) 99999-9999");
    }

    /**
     * Método que testa a função exibirContato de Contato
     */
    @Test
    void testExibirContato() {
        assertEquals("Charles Bezerra - (84) 99999-9999", contato1.exibirContato());
        assertEquals("Pedro Castanha - (84) 99999-9999", contato2.exibirContato());
        assertEquals("Charles Bezerra - (84) 99999-9999", contato3.exibirContato());
        assertEquals("Matheus Oliveira - (84) 99999-9999", contato4.exibirContato());
    }

    /**
     * Método que testa a função toString de Contato
     */
    @Test
    void testToString() {
        assertEquals("Charles Bezerra", contato1.toString());
        assertEquals("Pedro Castanha", contato2.toString());
        assertEquals("Charles Bezerra", contato3.toString());
        assertEquals("Matheus Oliveira", contato4.toString());
    }

    /**
     * Método que testa a função equals de Contato
     */
    @Test
    void testEquals() {
        assertTrue(contato1.equals(contato3));
        assertFalse(contato2.equals(contato3));
        assertFalse(contato3.equals(contato4));
        assertFalse(contato4.equals(contato1));
    }
}