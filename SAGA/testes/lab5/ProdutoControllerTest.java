package lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoControllerTest {

    private ProdutoController produtos;

    @BeforeEach
    void criarObjetos(){
        this.produtos = new ProdutoController();
    }

    @Test
    void testAdiciona() {
    }

    @Test
    void testAdicionaComNomeNulo() {
    }

    @Test
    void testAdicionaComNomeInvalido() {
    }
    
    @Test
    void testAdicionaComDescricaoNula() {
    }

    @Test
    void testAdicionaComDescricaoInvalida() {
    }
    
    @Test
    void testAdicionaComPrecoNulo() {
    }

    @Test
    void testAdicionaComPrecoInvalido() {
    }

    @Test
    void testExibe() {
    }

    @Test
    void testExibeComProdutoInegistente() {
    }

    @Test
    void testExibeComNomeNulo() {
    }
    
    @Test
    void testExibeComNomeInvalido() {
    }

    @Test
    void testExibeComDescricaoNula() {
    }
    
    @Test
    void testExibeComDescricaoInvalida() {
    }

    @Test
    void testLista() {
    }

    @Test
    void testEdita() {
    }
    
    @Test
    void testEditaComNomeNulo() {
    }

    @Test
    void testEditaComNomeInvalido() {
    }

    @Test
    void testEditaComDescricaoNula() {
    }

    @Test
    void testEditaComDescricaoInvalida() {
    }

    @Test
    void testEditaValorNulo() {
    }

    @Test
    void testEditaComValorInvalido() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void testRemoveNomeNulo() {
    }

    @Test
    void testRemoveNomeInvalido() {
    }

    @Test
    void testRemoveDescricaoNula() {
    }

    @Test
    void testRemoveDescricaoInvalida() {
    }
}
