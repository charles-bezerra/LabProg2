package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ControleDeAluno {
    private Map<String, Aluno> alunos;
    private Map<String, GrupoDeEstudo> gruposDeEstudo;
    private ArrayList<String> ordemDasRespostasDeAlunos;

    ControleDeAluno(){
        this.alunos =  new HashMap<>();
        this.gruposDeEstudo = new HashMap<>();
        this.ordemDasRespostasDeAlunos = new ArrayList<>();
    }

    public String validaEntradasString(String argumento, String variavel){
        if (argumento == null)
            throw new NullPointerException();

        String subArgumento = argumento.trim();

        if (subArgumento.equals(""))
            throw new IllegalArgumentException("O " + variavel + " deve ser diferente de \"\"");

        return argumento;
    }

    public boolean cadastrarGrupoDeEstudo(String tema){
        tema = this.validaEntradasString(tema, "tema");

        if (!this.gruposDeEstudo.containsKey(tema)) {
            this.gruposDeEstudo.put(tema, new GrupoDeEstudo(tema));
            return true;
        }else return false;
    }

    public boolean cadastrarAluno(String matricula, String nome, String curso) {
        matricula = validaEntradasString(matricula, "matricula");
        nome = this.validaEntradasString(nome, "nome");
        curso = this.validaEntradasString(curso, "tema");

        if (!this.alunos.containsKey(matricula)){
            this.alunos.put(matricula, new Aluno(matricula, nome, curso));
            return true;
        }else return false;
    }

    public String exibirAluno(String matricula){
        matricula = this.validaEntradasString(matricula, "matricula");
        return this.alunos.containsKey(matricula) ? "Aluno: " + this.alunos.get(matricula).toString() + "\n" : null;
    }

    public int alocarAlunoEmGrupo(String matricula, String grupo){
        matricula = validaEntradasString(matricula, "matricula");
        grupo = validaEntradasString(grupo, "grupo");

        if (!this.alunos.containsKey(matricula)) return 1;
        if (!this.gruposDeEstudo.containsKey(grupo)) return 2;

        this.gruposDeEstudo.get(grupo).adicionarAluno(this.alunos.get(matricula));
        return 3;
    }
    
    public String listarGrupo(String grupo){
        grupo = this.validaEntradasString(grupo, "grupo");

        if (!this.gruposDeEstudo.containsKey(grupo)) return null;
        return this.gruposDeEstudo.get(grupo).listarGrupo() + "\n";
    }

    public boolean cadastrarRespostaDeAlunos(String matricula){
        if (!this.alunos.containsKey(matricula)) return false;
        this.ordemDasRespostasDeAlunos.add(matricula);
        return true;
    }

    public String listarRespostasDeAlunos(){
        int cont = 0;
        String resultado = "Alunos:\n";
        Iterator<String> iter = this.ordemDasRespostasDeAlunos.iterator();
        while(iter.hasNext())
            resultado += ++cont + ". " + this.alunos.get(iter.next()).toString() + "\n";
        return resultado;
    }
}

