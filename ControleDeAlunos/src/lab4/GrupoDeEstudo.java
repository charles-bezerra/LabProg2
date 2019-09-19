package lab4;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;

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
            if( this.alunos.containsKey( aluno.getMatricula() ) ) return false;
            this.alunos.put( aluno.getMatricula(), aluno );
            this.matriculaAlunos.add(aluno.getMatricula());
            return true;
        }
    }

    public String listarGrupo(){
        String resultado = "Alunos do grupo " + this.tema + ":\n";
        Iterator<String> iter = this.matriculaAlunos.iterator();

        while (iter.hasNext()){
            resultado += "* " + this.alunos.get(iter.next()).toString() + "\n";
        }

        return resultado;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.tema);
    }

    @Override
    public boolean equals(Object object){
        if(object == this) return true;
        if(object == null) return false;
        if(object.getClass() != this.getClass()) return false;

        GrupoDeEstudo outroObjeto = (GrupoDeEstudo) object;
        return outroObjeto.hashCode() == this.hashCode();
    }
}
