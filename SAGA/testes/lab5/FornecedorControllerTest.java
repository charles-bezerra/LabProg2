package lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorControllerTest {

    private FornecedorController fornecedores;

    @BeforeEach
    void criarObjetos(){
        this.fornecedores = new FornecedorController();
        this.fornecedores.adiciona("Helhao", "helhao@gmail.com", "99999999");
        this.fornecedores.adiciona("Rotatoria", "rotatoria@gmail.com", "8888888");
    }

    @Test
    void testAdicionaComNomeNulo() {
    	try {
    		this.fornecedores.adiciona(null, "email@gmail.com", "9999999");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: nome nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void testAdicionaComNomeInvalido() {
    	try {
    		this.fornecedores.adiciona("", "email@gmail.com", "9999999");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: nome nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void testAdicionaComEmailNulo() {
    	try {
    		this.fornecedores.adiciona("Zeno", null, "9999999");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: email nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void testAdicionaComEmailInvalido() {
    	try {
    		this.fornecedores.adiciona("Zeno", "", "9999999");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: email nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void testAdicionaComTelefoneNulo() {
    	try {
    		this.fornecedores.adiciona("Zeno", "zeno@gmail.com", null);
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: telefone nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void testAdicionaComTelefoneInvalido() {
    	try {
    		this.fornecedores.adiciona("Zeno", "zeno@gmail.com", "");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro no cadastro de fornecedor: telefone nao pode ser vazio ou nulo.", error.toString());
    	}
    }


    @Test
    void testExibeComNomeNulo() {
    	try {
    		this.fornecedores.exibe(null);
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro na exibicao de fornecedor: nome nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void testExibeComNomeInvalido() {
    	try {
    		this.fornecedores.exibe("");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro na exibicao de fornecedor: nome nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void testLista() {
    	String listagem = "Helhao - helhao@gmail.com - 99999999 | Rotatoria - rotatoria@gmail.com - 8888888";
    	assertEquals(listagem, this.fornecedores.lista());
    }

    @Test
    void testEditaComNomeNulo() {
    	try {
    		this.fornecedores.edita(null, "email", "teste");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro na edicao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", error.toString());
    	}
    }
    
    @Test
    void testEditaComNomeInvalido() {
    	try {
    		this.fornecedores.edita("", "email", "teste");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro na edicao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", error.toString());
    	}    	
    }
    
    @Test
    void testEditaComAtributoNulo() {
    	try {
    		this.fornecedores.edita("Helhao", null, "teste");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", error.toString());
    	}
    }
    
    @Test
    void testEditaComAtributoInvalido() {
    	try {
    		this.fornecedores.edita("Helhao", "", "teste");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.", error.toString());
    	}    	
    }
    
    @Test
    void testEditaComAtributoInegistente() {
    	try {
    		this.fornecedores.edita("Helhao", "carro", "teste");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro na edicao do fornecedor: atributo nao existe.", error.toString());
    	}
    }

    @Test
    void testRemoveNomeNulo() {
    	try {
    		this.fornecedores.remove(null);
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", error.toString());
    	}
    }

    @Test
    void testRemoveNomeInvalido() {
    	try {
    		this.fornecedores.remove("");
    		fail("Exceção deveria ser lançada!");
    	}catch(IllegalArgumentException error) {
    		assertEquals("java.lang.IllegalArgumentException: Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.", error.toString());
    	}
    }
}