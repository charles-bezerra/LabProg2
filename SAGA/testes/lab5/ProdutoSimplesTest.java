package lab5;

import lab5.abstracts.Produto;
import lab5.comparetors.classes.ProdutoSimples;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class ProdutoSimplesTest {

	private ProdutoSimples produto;
	
    @BeforeEach
    void criarObjetos() {
    	this.produto = new ProdutoSimples("X-frango","Muito bom", 4.9);
    }


    @Test
    void testSetPrecoInvalido() {
    	try {
    		this.produto.setPreco(-1.0);
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do produto: preco invalido.", error.toString());
        }
    }

    @Test
    void testToString() {
    	assertEquals("X-frango - Muito bom - R$4,90", this.produto.toString());
    }

    @Test
    void testEquals() {
    	Produto p = new ProdutoSimples("X-frango", "Muito bom", 10.0);
        assertEquals(this.produto, p);
    }
}
