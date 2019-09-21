package lab4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ControleDeAlunoTest {
    private ControleDeAluno controle1;
    private static final String LS = System.lineSeparator();

    @BeforeEach
    void criarObjetos(){ controle1 = new ControleDeAluno(); }

    @Test
    void testCadastrarGrupoDeEstudoComTemaValido() {
        assertTrue( controle1.cadastrarGrupoDeEstudo("Grupo 1") );
    }

    @Test
    void testCadastrarGrupoDeEstudoComTemaNulo() {
        try {
            controle1.cadastrarGrupoDeEstudo(null);
            fail("Exceção deveria ser executada!");
        }catch (NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        }
    }

    @Test
    void testCadastrarGrupoDeEstudoComTemaInvalido() {
        try {
            controle1.cadastrarGrupoDeEstudo("");
            fail("Exceção deveria ser executada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: O ARGUMENTO <tema> DEVE CONTER VALORES DIFERENTES DE VAZIO", error.toString());
        }
    }

    @Test
    void testCadastrarGrupoDeEstudoComTemaRepetido(){
        controle1.cadastrarGrupoDeEstudo("Grupo 2");
        assertFalse( controle1.cadastrarGrupoDeEstudo("Grupo 2") );
    }

    @Test
    void testCadastrarAlunoComMatriculaNula() {
        try {
            controle1.cadastrarAluno(null, "Aluno 1", "Computação" );
        }catch (NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        }
    }

    @Test
    void testCadastrarAlunoComNomeNulo() {
        try {
            controle1.cadastrarAluno("2019", null, "Computação" );
        }catch (NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        }
    }

    @Test
    void testCadastrarAlunoComCursoNulo() {
        try {
            controle1.cadastrarAluno("2019", "Aluno 1", null );
        }catch (NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        }
    }

    @Test
    void testExibirAlunoExistente() {
        controle1.cadastrarAluno("2019","Aluno 1", "Computação");
        assertEquals("Aluno: 2019 - Aluno 1 - Computação", controle1.exibirAluno("2019"));
    }

    @Test
    void testExibirAlunoNaoExistente() {
        assertEquals( null, controle1.exibirAluno("2019"));
    }

    @Test
    void testAlocarAlunoEmGrupo_MatriculaNula() {
        try {
            controle1.alocarAlunoEmGrupo(null, "grupo 1");
        }catch (NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        }
    }

    @Test
    void testAlocarAlunoEmGrupo_GrupoNulo() {
        try {
            controle1.alocarAlunoEmGrupo("2019", null);
        }catch (NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        }
    }

    @Test
    void testAlocarAlunoEmGrupo_MatriculaGrupoNulos() {
        try {
            controle1.alocarAlunoEmGrupo(null, null);
        }catch (NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        }
    }

    @Test
    void testListarGrupoValido() {
        controle1.cadastrarAluno("2019.1","Aluno 1", "Computação");
        controle1.cadastrarAluno("2019.2","Aluno 2", "Computação");

        controle1.cadastrarGrupoDeEstudo("2019");

        controle1.alocarAlunoEmGrupo("2019.1", "2019");
        controle1.alocarAlunoEmGrupo("2019.2", "2019");

        String listagem =
                "Alunos do grupo 2019:" + LS +
                        "* 2019.1 - Aluno 1 - Computação" + LS +
                        "* 2019.2 - Aluno 2 - Computação" + LS;

        assertEquals(listagem, controle1.listarGrupo("2019"));
    }

    @Test
    void testListarGrupoNulo() {
        controle1.cadastrarAluno("2019.1", "Aluno 1", "Computação");
        controle1.cadastrarAluno("2019.2", "Aluno 2", "Computação");
        controle1.cadastrarGrupoDeEstudo("2019");

        String listagem =
                "Alunos do grupo Grupo 1:" + LS +
                        "* 2019.1 - Aluno 1 - Computação" + LS +
                        "* 2019.2 - Aluno 2 - Computação" + LS;
        try {
            controle1.listarGrupo(null);
            fail("Exceção deveria ser executada!");
        }catch (NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        }
    }

    @Test
    void testCadastrarRespostaDeAlunos_AlunoNulo() {
        try {
            controle1.cadastrarRespostaDeAlunos(null);
            fail("Exceção deveria ser executada!");
        }catch (NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        }
    }

    @Test
    void testCadastrarRespostaDeAlunos_AlunoInvalido() {
        try {
            controle1.cadastrarRespostaDeAlunos("");
            fail("Exceção deveria ser executada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: O ARGUMENTO <matricula> DEVE CONTER VALORES DIFERENTES DE VAZIO", error.toString());
        }
    }
}