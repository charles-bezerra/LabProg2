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
        assertEquals("CADASTRO REALIZADO!\n", controle1.cadastrarGrupoDeEstudo("Grupo 1") );
        assertEquals( "TEMA INVÁLIDO!\n", controle1.cadastrarGrupoDeEstudo(null) );
        assertEquals( "TEMA INVÁLIDO!\n", controle1.cadastrarGrupoDeEstudo("") );

        controle1.cadastrarGrupoDeEstudo("Grupo 2");
        assertEquals("GRUPO JÁ CADASTRADO!\n", controle1.cadastrarGrupoDeEstudo("Grupo 2"));
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