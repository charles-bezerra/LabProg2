package lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoDeEstudoTest {

    private GrupoDeEstudo grupo1, grupo2;

    @BeforeEach
    void criarObjetos(){
        grupo1 = new GrupoDeEstudo("Grupo 1");
        grupo2 = new GrupoDeEstudo("Grupo 2");
    }

    @Test
    void adicionarAluno() {
    }

    @Test
    void listarGrupo() {
    }

    @Test
    void equals() {
    }
}