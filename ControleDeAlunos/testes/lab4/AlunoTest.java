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
        assertTrue( aluno1.hashCode() == aluno2.hashCode());
        assertFalse( aluno1.hashCode() == aluno3.hashCode());
        assertFalse(aluno2.hashCode() == aluno3.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("1 - Charles - Computação", aluno1.toString());
        assertEquals("1 - Carlos - Computação", aluno2.toString());
        assertEquals("2 - Henrique - História", aluno3.toString());
    }

    @Test
    void testEquals() {
        assertTrue(aluno1.equals(aluno2));
        assertFalse(aluno1.equals(aluno3));
        assertFalse(aluno2.equals(aluno3));
    }
}