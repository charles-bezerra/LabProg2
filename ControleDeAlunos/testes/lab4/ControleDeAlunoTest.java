package lab4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ControleDeAlunoTest {

    private ControleDeAluno controle1;

    @BeforeEach
    void criarObjetos(){
        controle1 = new ControleDeAluno();
    }

    @Test
    void testCadastrarGrupoDeEstudo() {
        assertTrue( controle1.cadastrarGrupoDeEstudo("Grupo 1") );

        try {
            controle1.cadastrarGrupoDeEstudo(null);
            fail("Exceção deveria ser executada!");
        }catch (NullPointerException error){

        }

        try {
            controle1.cadastrarGrupoDeEstudo("");
            fail("Exceção deveria ser executada!");
        }catch (IllegalArgumentException error){

        }

        controle1.cadastrarGrupoDeEstudo("Grupo 2");
        assertFalse( controle1.cadastrarGrupoDeEstudo("Grupo 2") );
    }

    @Test
    void testCadastrarAluno() {
    }

    @Test
    void testExibirAluno() {
    }

    @Test
    void testAlocarAlunoEmGrupo() {
    }

    @Test
    void testListarGrupo() {
    }

    @Test
    void testCadastrarRespostaDeAlunos() {
    }

    @Test
    void testListarRespostasDeAlunos() {
    }
}