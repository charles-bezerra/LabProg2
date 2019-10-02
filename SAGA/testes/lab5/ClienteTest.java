package lab5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void criarObjetos(){
        this.cliente = new Cliente("123","Charles Bezerra", "charles@gmail.com", "MyLab");
    }

    @Test
    void testCriarComCpfNulo() {
        try {
            Cliente cliente1 = new Cliente(null, "Cliente 1", "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testCriarComCpfInvalido() {
        try {
            Cliente cliente1 = new Cliente("", "Cliente 1", "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testCriarComNomeNulo() {
        try {
            Cliente cliente1 = new Cliente("123456", null, "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testCriarComNomeInvalido() {
        try {
            Cliente cliente1 = new Cliente("123456", "", "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testCriarComEmailNulo() {
        try {
            Cliente cliente1 = new Cliente("123456", "Cliente 1", null,"LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testCriarComEmailInvalido() {
        try {
            Cliente cliente1 = new Cliente("123456", "Cliente 1", "","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testCriarComLocalizacaoNulo() {
        try {
            Cliente cliente1 = new Cliente("123456", "Cliente", "cliente1@gmail.com",null);
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testCriarComTelefoneInvalido() {
        try {
            Cliente cliente1 = new Cliente("123456", "Cliente", "cliente1@gmail.com","");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.", error.toString());
        }
    }


    @Test
    void testEditaComValorNulo() {
    }

    @Test
    void testEditaComValorInvalido() {
    }

    @Test
    void testEditaComAtributoNulo() {
    }

    @Test
    void testEditaComAtributoInvalido() {
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