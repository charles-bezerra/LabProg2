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
    private static final String LS = System.lineSeparator();

    GrupoDeEstudo(String tema){
        this.tema = ValidaArgumentos.verificarString(tema,"tema");
        this.alunos = new HashMap<>();
        this.matriculaAlunos = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno aluno){
        aluno = ValidaArgumentos.verificarAluno(aluno);

        if( this.alunos.containsKey( aluno.getMatricula() ) ) return false;

        this.alunos.put( aluno.getMatricula(), aluno );
        this.matriculaAlunos.add(aluno.getMatricula());
        return true;
    }

    /**
     *
     *
     * @return
     */
    public String listarGrupo(){
        StringBuilder resultado = new StringBuilder("Alunos do grupo " + this.tema + ":" + LS);
        Iterator<String> iter = this.matriculaAlunos.iterator();
        while (iter.hasNext()){
            resultado.append("* ").append( this.alunos.get( iter.next() ).toString() ).append(LS);
        }
        return resultado.toString();
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
