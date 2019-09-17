package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoDeEstudoTest {

    private GrupoDeEstudo grupo1, grupo2, grupo3;
    private Aluno aluno1, aluno2, aluno3;

    @BeforeEach
    void criarObjetos(){
        grupo1 = new GrupoDeEstudo("Grupo 1");
        grupo2 = new GrupoDeEstudo("Grupo Espelhado");
        grupo3 = new GrupoDeEstudo("Grupo Espelhado");

        aluno1 = new Aluno("1", "Charles", "Computação");
        aluno2 = new Aluno("2", "Carlos", "Computação");
        aluno3 = new Aluno("3", "Henrique", "História");

    }

    @Test
    void testAdicionarAluno() {
        assertTrue(grupo1.adicionarAluno(aluno1));

        grupo1.adicionarAluno(aluno1);

        assertFalse(grupo1.adicionarAluno(aluno1));
        assertFalse(grupo1.adicionarAluno(null));
    }

    @Test
    void testListarGrupo() {
        grupo1.adicionarAluno(aluno1);
        grupo1.adicionarAluno(aluno2);
        grupo1.adicionarAluno(aluno3);

        assertEquals("", grupo1.listarGrupo());
    }

    @Test
    void testEquals() {
    }
}