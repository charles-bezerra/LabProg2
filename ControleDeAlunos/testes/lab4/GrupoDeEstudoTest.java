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

        String listagem =
                "Alunos do grupo Grupo 1:\n" +
                "* 1 - Charles - Computação\n" +
                "* 2 - Carlos - Computação\n" +
                "* 3 - Henrique - História\n";

        assertEquals(listagem, grupo1.listarGrupo());
        assertEquals("Alunos do grupo Grupo Espelhado:\n", grupo2.listarGrupo());
        assertEquals("Alunos do grupo Grupo Espelhado:\n", grupo3.listarGrupo());
    }

    @Test
    void testHashCode(){
        assertFalse(grupo1.hashCode() == grupo2.hashCode());
        assertFalse(grupo1.hashCode() == grupo3.hashCode());
        assertTrue(grupo2.hashCode() == grupo3.hashCode());
    }

    @Test
    void testEquals() {
        assertFalse(grupo1.equals(grupo2));
        assertFalse(grupo1.equals(grupo3));
        assertTrue(grupo2.equals(grupo3));
    }
}