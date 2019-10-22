package lab5;

import lab5.classes.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void criarObjetos(){
        this.cliente = new Cliente("01762694441","Charles Bezerra", "charles@gmail.com", "MyLab");
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
            Cliente cliente1 = new Cliente("01762694441", null, "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testCriarComNomeInvalido() {
        try {
            Cliente cliente1 = new Cliente("01762694441", "", "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testCriarComEmailNulo() {
        try {
            Cliente cliente1 = new Cliente("01762694441", "Cliente 1", null,"LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testCriarComEmailInvalido() {
        try {
            Cliente cliente1 = new Cliente("01762694441", "Cliente 1", "","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testCriarComLocalizacaoNulo() {
        try {
            Cliente cliente1 = new Cliente("01762694441", "Cliente", "cliente1@gmail.com",null);
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", error.toString());
        }
    }

    @Test
    void testCriarComTelefoneInvalido() {
        try {
            Cliente cliente1 = new Cliente("01762694441", "Cliente", "cliente1@gmail.com","");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.", error.toString());
        }
    }


    @Test
    void testEditaComValorNulo() {
        try {
            this.cliente.edita("nome",null);
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testEditaComValorInvalido() {
        try {
            this.cliente.edita("nome","");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testEditaComAtributoNulo() {
        try {
            this.cliente.edita(null,"Cliente novo");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testEditaComAtributoInvalido() {
        try {
            this.cliente.edita("","Cliente novo");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testToString() {
        Cliente cliente1 = new Cliente("01762694441", "Cliente 1", "cliente@gmail.com", "myLab");
        assertEquals("Cliente 1 - myLab - cliente@gmail.com", cliente1.toString());
    }

    @Test
    void testHashCode() {
        Cliente cliente1 = new Cliente("01762694441", "Cliente 1", "cliente@gmail.com", "myLab");
        Cliente cliente2 = new Cliente("01762694441", "Cliente 2", "cliente1@gmail.com", "Lab");
        assertEquals(cliente1.hashCode(), cliente2.hashCode());
    }

    @Test
    void testEquals() {
        Cliente cliente1 = new Cliente("01762694441", "Cliente 1", "cliente@gmail.com", "myLab");
        Cliente cliente2 = new Cliente("01762694441", "Cliente 2", "cliente1@gmail.com", "Lab");
        assertEquals(cliente1, cliente2);
    }
}
