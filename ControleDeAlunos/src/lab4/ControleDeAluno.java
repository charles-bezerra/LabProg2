package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Classe controladora das instancias Aluno e GrupoDeEstudo
 */
public class ControleDeAluno {
    /**
     * Mapa responsável por guardar as matriculas de Aluno relacionadas aos Objetos do tipo Aluno
     */
    private Map<String, Aluno> alunos;

    /**
     * Mapa responsável por guardar os temas de GrupoDeEstudo relacionadas aos seus Objetos do tipo GrupoDeEstudo
     */
    private Map<String, GrupoDeEstudo> gruposDeEstudo;

    /**
     * Lista responsável por guardar as matriculas dos alunos em ordem que responderam as perguntas
     * podendo conter matriculas repetidas
     */
    private ArrayList<String> ordemDasRespostasDeAlunos;

    /**
     * Atributo que recebe a quebra de linha adequada para  vários tipos de sistemas operacionais
     */
    private final String LS = System.lineSeparator();

    /**
     * Contrutor do ControleDeAluno, não recebe parametros. Mas inicializa os objetos privados da instancia.
     */
    ControleDeAluno(){
        this.alunos =  new HashMap<>();
        this.gruposDeEstudo = new HashMap<>();
        this.ordemDasRespostasDeAlunos = new ArrayList<>();
    }

    /**
     *
     * Função responsável por cadastrar um grupo no Controle de Aluno
     *
     * @param tema nome do tema dado à um grupo de estudos
     * @return se o grupo pôde ser cadastrado ou não
     */
    public boolean cadastrarGrupoDeEstudo(String tema){
        tema = ValidaArgumentos.verificarString(tema, "tema");

        if (!this.gruposDeEstudo.containsKey(tema)) {
            this.gruposDeEstudo.put(tema, new GrupoDeEstudo(tema));
            return true;
        }else return false;
    }

    /**
     *
     * Função responsável por cadastrar um Aluno no Controle de Aluno
     *
     * @param matricula identificador único de Aluno
     * @param nome nome do Aluno
     * @param curso curso atual do Aluno
     * @return boolean que atesta se o cadastro foi realizado com sucesso true/false
     */
    public boolean cadastrarAluno(String matricula, String nome, String curso) {
        matricula = ValidaArgumentos.verificarString(matricula, "matricula");
        nome = ValidaArgumentos.verificarString(nome, "nome");
        curso = ValidaArgumentos.verificarString(curso, "tema");

        if (!this.alunos.containsKey(matricula)){
            this.alunos.put(matricula, new Aluno(matricula, nome, curso));
            return true;
        }else return false;
    }

    /**
     * Função responsável por retornar a exibição do aluno
     *
     * @param matricula String com o valor da matricula
     * @return String com <Aluno: representação do aluno>
     */
    public String exibirAluno(String matricula){
        matricula = ValidaArgumentos.verificarString(matricula, "matricula");
        return this.alunos.containsKey(matricula) ? "Aluno: " + this.alunos.get(matricula).toString() : null;
    }

    /**
     * Método responsável por alocar um Aluno em um GrupoDeEstudos retornando
     * um objeto do tipo Enum que representa informações da cadastro.
     *
     * @param matricula identificador do Aluno
     * @param grupo tema que identifica o grupo de estudo
     * @return retorna um Enum que identifica algum tipo de mensagem
     */
    public MensagensAlocarAluno alocarAlunoEmGrupo(String matricula, String grupo){
        matricula = ValidaArgumentos.verificarString(matricula, "matricula");
        grupo = ValidaArgumentos.verificarString(grupo, "grupo");

        if (!this.alunos.containsKey(matricula)) return MensagensAlocarAluno.AlunoNaoEncontrado;
        if (!this.gruposDeEstudo.containsKey(grupo)) return MensagensAlocarAluno.GrupoNaoEncontrado;

        this.gruposDeEstudo.get(grupo).adicionarAluno(this.alunos.get(matricula));
        return MensagensAlocarAluno.CadastradoComSucesso;
    }

    /**
     * Método que lista um grupo de estudos e os alunos desse grupo
     *
     * @param grupo identificador do grupo de estudos
     * @return String com informações do grupo e os seus alunos
     */
    public String listarGrupo(String grupo){
        grupo = ValidaArgumentos.verificarString(grupo, "grupo");
        if (!this.gruposDeEstudo.containsKey(grupo)) return null;
        return this.gruposDeEstudo.get(grupo).listarGrupo();
    }

    /**
     * Método que cadastra uma resposta de um aluno
     *
     * @param matricula String identifica um aluno
     * @return boolean que identifica se a resposta foi cadastrada com sucesso
     */
    public boolean cadastrarRespostaDeAlunos(String matricula){
        matricula = ValidaArgumentos.verificarString(matricula, "matricula");
        if (!this.alunos.containsKey(matricula)) return false;
        this.ordemDasRespostasDeAlunos.add(matricula);
        return true;
    }

    /**
     * Método que lista os alunos que responderam em ordem de resposta
     *
     * @return String contendo os alunos que responderam
     */
    public String listarRespostasDeAlunos(){
        int cont = 0;
        String resultado = "Alunos:" + LS;
        Iterator iter = this.ordemDasRespostasDeAlunos.iterator();
        while(iter.hasNext())
            resultado += ++cont + ". " + this.alunos.get( iter.next() ).toString() + LS;
        return resultado;
    }
}