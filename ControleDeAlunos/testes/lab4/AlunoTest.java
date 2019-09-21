package lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {
    private Aluno aluno1, aluno2, aluno3;

    @BeforeEach
    void criarObjetos(){
        aluno1 = new Aluno("1", "Charles", "Computação");
        aluno2 = new Aluno("1", "Carlos", "Computação");
        aluno3 = new Aluno("2", "Henrique", "História");
    }

    @Test
    void testCriarObjetosMatriculaNula(){
        try {
            Aluno aluno = new Aluno(null, "aluno 1", "Computação");
            fail("Exceção deveria ser executada");
        }catch(NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        };
    }

    @Test
    void testCriarObjetosNomeNulo(){
        try {
            Aluno aluno = new Aluno("2019.1", null, "Computação");
            fail("Exceção deveria ser executada");
        }catch(NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        };
    }

    @Test
    void testCriarObjetosCursoNulo(){
        try {
            Aluno aluno = new Aluno("2019.1", "aluno 1", null);
            fail("Exceção deveria ser executada");
        }catch(NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        };
    }

    @Test
    void testCriarObjetosMatriculaInvalida(){
        try {
            Aluno aluno = new Aluno("", "aluno 1", "Computação");
            fail("Exceção deveria ser executada");
        }catch(IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: O ARGUMENTO <matricula> DEVE CONTER VALORES DIFERENTES DE VAZIO", error.toString());
        };
    }

    @Test
    void testCriarObjetosNomeInvalido(){
        try {
            Aluno aluno = new Aluno("2019.1", "", "Computação");
            fail("Exceção deveria ser executada");
        }catch(IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: O ARGUMENTO <nome> DEVE CONTER VALORES DIFERENTES DE VAZIO", error.toString());
        };
    }

    @Test
    void testCriarObjetosCursoInvalido(){
        try {
            Aluno aluno = new Aluno("2019.1", "aluno 1", "");
            fail("Exceção deveria ser executada");
        }catch(IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: O ARGUMENTO <curso> DEVE CONTER VALORES DIFERENTES DE VAZIO", error.toString());
        };
    }

    @Test
    void testGetMatricula() {
       assertEquals("1", aluno1.getMatricula());
       assertEquals("1", aluno2.getMatricula());
       assertEquals("2", aluno3.getMatricula());
    }

    @Test
    void testGetNome() {
        assertEquals("Charles", aluno1.getNome());
        assertEquals("Carlos", aluno2.getNome());
        assertEquals("Henrique", aluno3.getNome());
    }

    @Test
    void testGetCurso() {
        assertEquals("Computação", aluno1.getCurso());
        assertEquals("Computação", aluno2.getCurso());
        assertEquals("História", aluno3.getCurso());
    }

    @Test
    void testHashCode() {
        assertEquals( aluno1.hashCode(), aluno2.hashCode());
        assertNotEquals( aluno1.hashCode(), aluno3.hashCode());
        assertNotEquals(aluno2.hashCode() , aluno3.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("1 - Charles - Computação", aluno1.toString());
        assertEquals("1 - Carlos - Computação", aluno2.toString());
        assertEquals("2 - Henrique - História", aluno3.toString());
    }

    @Test
    void testEquals() {
        assertEquals(aluno1, aluno2);
        assertNotEquals(aluno1, aluno3);
        assertNotEquals(aluno2, aluno3);
    }
}