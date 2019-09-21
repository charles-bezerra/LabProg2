package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoDeEstudoTest {
    private GrupoDeEstudo grupo1, grupo2, grupo3;
    private Aluno aluno1, aluno2, aluno3;
    private static final String LS = System.lineSeparator();


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
    void testAdicionarAlunoValido() {
        assertTrue(grupo1.adicionarAluno(aluno1));
    }

    @Test
    void testAdicionarAlunoNulo() {
        try {
            grupo1.adicionarAluno(null);
        }catch (NullPointerException error){
            assertEquals("java.lang.NullPointerException", error.toString());
        }
    }

    @Test
    void testListarGrupo() {
        grupo1.adicionarAluno(aluno1);
        grupo1.adicionarAluno(aluno2);
        grupo1.adicionarAluno(aluno3);

        String listagem =
                "Alunos do grupo Grupo 1:" + LS +
                "* 1 - Charles - Computação" + LS +
                "* 2 - Carlos - Computação" + LS +
                "* 3 - Henrique - História" + LS;

        assertEquals(listagem, grupo1.listarGrupo());
        assertEquals("Alunos do grupo Grupo Espelhado:" + LS, grupo2.listarGrupo());
        assertEquals("Alunos do grupo Grupo Espelhado:" + LS, grupo3.listarGrupo());
    }

    @Test
    void testHashCode(){
        assertNotEquals(grupo1.hashCode(), grupo2.hashCode());
        assertNotEquals(grupo1.hashCode(), grupo3.hashCode());
        assertEquals(grupo2.hashCode(), grupo3.hashCode());
    }

    @Test
    void testEquals() {
        assertNotEquals(grupo1, grupo2);
        assertNotEquals(grupo1, grupo3);
        assertEquals(grupo2, grupo3);
    }
}