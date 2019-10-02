package lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteControllerTest {

    private ClienteController clientes;

    @BeforeEach
    void criar objetos() {
         this.clientes = new ClienteController();
         this.clientes.adiciona("017.626.944-41", "Charles", "charlesbezerra5@gmail.com", "SPLab")
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
            this.clientes.adiciona("12345", null, "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testAdicionaComNomeInvalido() {
        try {
            this.clientes.adiciona("12345", "", "cliente@gmail.com","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testAdicionaComEmailNulo() {
        try {
            this.clientes.adiciona("12345", "Cliente 1", null,"LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testAdicionaComEmailInvalido() {
        try {
            this.clientes.adiciona("12345", "Cliente 1", "","LabCliente");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: email nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testAdicionaComLocalizacaoNula() {
        try {
            this.clientes.adiciona("12345", "Cliente 1", "cliente@gmail.com", null);
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.", error.toString());
        }
    }

    @Test
    void testAdicionaComLocalizacaoInvalida() {
        try {
            this.clientes.adiciona("12345", "Cliente 1", "cliente@gmail.com","");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo.", error.toString());
        }
    }


    @Test
    void testExibeComClienteInegistente(){
         try {
            this.clientes.exibe("12345");
            fail("Exceção deveria ser lançada!");
        }catch (IllegalArgumentException error){
            assertEquals("java.lang.IllegalArgumentException: Erro na exibicao do cliente: cliente não existe", error.toString());
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
    void testLista() {
    }

    @Test
    void testEditaComCpfNulo() {
    }

    @Test
    void testEditaComCpfInvalido() {
    }

    @Test
    void testEditaComAtributoNulo() {
    }

    @Test
    void testEditaComAtributoInvalido() {
    }

    @Test
    void testEditaComAtributoInegistente() {
    }

    @Test
    void testEditaComValorNulo() {
    }

    @Test
    void testEditaComValorInvalido() {
    }

    @Test
    void testRemoveCpfNulo() {
    }

    @Test
    void testRemoveCpfInvalido() {
    }

    @Test
    void testRemoveCpfInegistente() {
    }

}
