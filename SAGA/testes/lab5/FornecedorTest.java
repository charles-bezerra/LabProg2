package lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    private Fornecedor fornecedor;

    @BeforeEach
    void criarObjetos(){
        this.fornecedor = new Fornecedor("Helhão", "helhao@gmail.com","(83) 0000-0000");
    }

    @Test
    void testEditaComAtributoNulo() {
    }

    @Test
    void testEditaComAtributoInvalido() {
    }

    @Test
    void testEditaComValorNulo() {
    }

    @Test
    void testEditaComValorInvalido() {
    }

    @Test
    void testAdicionaProduto() {
    }

    @Test
    void testRemoveProduto() {
    }

    @Test
    void testEditaProduto() {
    }

    @Test
    void testExibeProduto() {
    }

    @Test
    void testListaProdutos() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testEquals() {
    }
}