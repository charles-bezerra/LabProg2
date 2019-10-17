package lab5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ClienteControllerTest {

    private ClienteController clientes;

    @BeforeEach
    void criarObjetos() {
         this.clientes = new ClienteController();
         this.clientes.adiciona("01762694441", "Charles", "charles@gmail.com", "SPLab");
         this.clientes.adiciona("01762694442", "Bezerra", "bezerra@gmail.com", "LSD");
         this.clientes.adiciona("01762694443", "Oliveira", "oliveira@gmail.com", "LIT");
    }

    @Test
    void testAdicionaComCpfNulo() {
        try {
            this.clientes.adiciona(null, "Cliente 1", "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", error.toString());
        }      
    }

    @Test
    void testAdicionaComCpfInvalido() {
        try {
            this.clientes.adiciona("", "Cliente 1", "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testAdicionaComNomeNulo() {
        try {
            this.clientes.adiciona("12312312345", null, "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testAdicionaComNomeInvalido() {
        try {
            this.clientes.adiciona("12312312345", "", "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testAdicionaComEmailNulo() {
        try {
            this.clientes.adiciona("12312312345", "Cliente 1", null,"LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testAdicionaComEmailInvalido() {
        try {
            this.clientes.adiciona("12312312345", "Cliente 1", "","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testAdicionaComLocalizacaoNula() {
        try {
            this.clientes.adiciona("12312312345", "Cliente 1", "cliente@gmail.com", null);
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", error.toString());
        }
    }

    @Test
    void testAdicionaComLocalizacaoInvalida() {
        try {
            this.clientes.adiciona("12312312345", "Cliente 1", "cliente@gmail.com","");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", error.toString());
        }
    }


    @Test
    void testExibeComClienteInegistente(){
         try {
            this.clientes.exibe("12312312345");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na exibicao do cliente: cliente nao existe.", error.toString());
        }
    }

    @Test
    void testExibeComCpfNulo() {
        try {
            this.clientes.exibe(null);
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testExibeComCpfInvalido() {
        try {
            this.clientes.exibe("");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testExibeClientes() {
    	String listagem = "Bezerra - LSD - bezerra@gmail.com | Charles - SPLab - charles@gmail.com | Oliveira - LIT - oliveira@gmail.com";
    	assertEquals(listagem, this.clientes.exibeClientes());
    }

    @Test
    void testEditaComCpfNulo() {
        try {
            this.clientes.edita(null, "nome", "teste");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testEditaComCpfInvalido() {
        try {
            this.clientes.edita("", "nome", "teste");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testEditaComAtributoNulo() {
        try {
            this.clientes.edita("01762694441", null, "teste");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testEditaComAtributoInvalido() {
        try {
            this.clientes.edita("01762694441", "", "teste");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testEditaComAtributoInegistente() {
        try {
            this.clientes.edita("01762694441", "sobrenome", "teste");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do cliente: atributo nao existe.", error.toString());
        }
    }

    @Test
    void testEditaComValorNulo() {
        try {
            this.clientes.edita("01762694441", "nome", null);
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testEditaComValorInvalido() {
        try {
            this.clientes.edita("01762694441", "nome", "");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testRemoveCpfNulo() {
        try {
            this.clientes.remove(null);
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na remocao do cliente: cpf nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testRemoveCpfInvalido() {
        try {
            this.clientes.remove("");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na remocao do cliente: cpf nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testRemoveCpfInegistente() {
        try {
            this.clientes.remove("1234567");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na remocao do cliente: cliente nao existe.", error.toString());
        }
    }

}
