package lab5;

import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    private Fornecedor fornecedor;

    @BeforeEach
    void criarObjetos(){
        this.fornecedor = new Fornecedor("Helhao", "helhao@gmail.com","(83) 0000-0000");
    }

    @Test
    void criarFornecedorComNomeNulo() {
    	try {
    		Fornecedor f = new Fornecedor(null, "email@gmail.com", "9999999");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: nome nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void criarFornecedorComNomeInvalido() {
    	try {
    		Fornecedor f = new Fornecedor("", "email@gmail.com", "9999999");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: nome nao pode ser vazio ou nulo.", error.toString());
    	}
    }
    
    @Test
    void criarFornecedorComEmailNulo() {
    	try {
    		Fornecedor f = new Fornecedor("Zeno", null, "9999999");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: email nao pode ser vazio ou nulo.", error.toString());
    	}
    }
    
    @Test
    void criarFornecedorComEmailInvalido() {
    	try {
    		Fornecedor f = new Fornecedor("Zeno", "", "9999999");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: email nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void criarFornecedorComTelefoneNulo() {
    	try {
    		Fornecedor f = new Fornecedor("Zeno", "email@gmail.com", null);
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: telefone nao pode ser vazio ou nulo.", error.toString());
    	}
    }
    
    @Test
    void criarFornecedorComTelefoneInvalido() {
    	try {
    		Fornecedor f = new Fornecedor("Zeno", "email@gmail.com", "");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: telefone nao pode ser vazio ou nulo.", error.toString());
    	}
    }
    
    @Test
    void testEditaComAtributoNulo() {
    	try {
    		this.fornecedor.edita(null, "teste");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no edicao de fornecedor: atributo nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void testEditaComAtributoInvalido() {
    	try {
    		this.fornecedor.edita("", "teste");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no edicao de fornecedor: atributo nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void testEditaComValorNulo() {
    	try {
    		this.fornecedor.edita("Helhao", null);
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no edicao de fornecedor: novo valor nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void testEditaComValorInvalido() {
    	try {
    		this.fornecedor.edita("Helhao", "");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no edicao de fornecedor: novo valor nao pode ser vazio ou nulo.", error.toString());
    	}
    }


    @Test
    void testToString() {
    	assertEquals("Helhao - helhao@gmail.com", "(83) 0000-0000", this.fornecedor.toString());
    }

    @Test
    void testEquals() {
    	Fornecedor fornecedor = new Fornecedor("Helhao", "email@gmail.com", "8989789789");
    	assertEquals(this.fornecedor, fornecedor);
    }
}