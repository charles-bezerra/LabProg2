package lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class GrupoDeEstudo {
    private String tema;
    private Map<String, Aluno> alunos;
    private ArrayList<String> matriculaAlunos;

    GrupoDeEstudo(String tema){
        this.tema = tema;
        this.alunos = new HashMap<>();
        this.matriculaAlunos = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno aluno){
        if(aluno == null) return false;
        else{
            if( this.alunos.containsKey( aluno.getMatricula() ) )
                return false;
            this.alunos.put( aluno.getMatricula(), aluno );
            this.matriculaAlunos.add(aluno.getMatricula());
            return true;
        }
    }

    public String listarGrupo(){
        String resultado = "Alunos do grupo Listas:\n";
        Iterator<String> iter = this.matriculaAlunos.iterator();
        while (iter.hasNext()){
            resultado += "* " + this.alunos.get(iter.next()).toString() + "\n";
        }
        return resultado;
    }

    public int hashCode(){
        return this.tema.hashCode();
    }

    public boolean equals(Object objeto){
        if(objeto == this) return true;
        if(objeto == null) return false;
        if(objeto.getClass() != this.getClass()) return false;

        GrupoDeEstudo outroObjeto = (GrupoDeEstudo) objeto;
        return outroObjeto.hashCode() == this.hashCode();
    }
}
