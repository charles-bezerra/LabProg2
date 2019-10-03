package lab5;

import org.junit.jupiter.api.Test; 

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class ProdutoTest {

	private Produto produto;
	
    @BeforeEach
    void criarObjetos() {
    	this.produto = new Produto("X-frango","Muito bom", 4.9);
    }

    @Test
    void testSetPrecoNulo() {
    	try {
    		this.produto.setPreco(null);
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do produto: preco nao pode ser vazio ou nulo.", error.toString());
        }
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
    	Double preco = new Double(4.9);
    	assertEquals("X-frango - Muito bom - R$" + preco.toString(), this.produto.toString());
    }

    @Test
    void testEquals() {
    	Produto p = new Produto("X-frango", "Muito bom", 10.0);
        assertEquals(this.produto, p);
    }
}
