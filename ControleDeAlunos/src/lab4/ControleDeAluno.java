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

    public boolean cadastrarGrupoDeEstudo(String tema){
        if (!this.gruposDeEstudo.containsKey(tema)) {
            this.gruposDeEstudo.put(tema, new GrupoDeEstudo(tema));
            return true;
        }else return false;
    }

    public boolean cadastrarAluno(String matricula, String nome, String curso) {
        if (!this.alunos.containsKey(matricula)){
            this.alunos.put(matricula, new Aluno(matricula, nome, curso));
            return true;
        }else return false;
    }

    public String exibirAluno(String matricula){
        return this.alunos.containsKey(matricula) ? "Aluno: " + this.alunos.get(matricula).toString() + "\n" : "Aluno não cadastrado. \n";
    }

    public String alocarAlunoEmGrupo(String matricula, String grupo){
        if (!this.alunos.containsKey(matricula)) return "Aluno não cadastrado. \n";
        if (!this.gruposDeEstudo.containsKey(grupo)) return "Grupo não cadastrado. \n";

        this.gruposDeEstudo.get(grupo).adicionarAluno(this.alunos.get(matricula));
        return "ALUNO ALOCADO! \n";
    }

    public String listarGrupo(String grupo){
        if (!this.gruposDeEstudo.containsKey(grupo)) return "Grupo não cadastrado. \n";
        return this.gruposDeEstudo.get(grupo).listarGrupo() + "\n";
    }

    public String cadastrarRespostaDeAlunos(String matricula){
        if (!this.alunos.containsKey(matricula)) return "Aluno não cadastrado. \n";
        this.ordemDasRespostasDeAlunos.add(matricula);
        return "ALUNO REGISTRADO! \n";
    }

    public String listarRespostasDeAlunos(){
        int cont = 0;
        String resultado = "Alunos: \n";
        Iterator iter = this.ordemDasRespostasDeAlunos.iterator();
        while(iter.hasNext())
            resultado += ++cont + ". " + this.alunos.get(iter.next()).toString() + "\n";
        return resultado;
    }
}