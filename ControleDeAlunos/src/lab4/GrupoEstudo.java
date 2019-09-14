package lab4;
import java.util.ArrayList;

public class GrupoEstudo {
    private String tema;
    private ArrayList<Aluno> alunos;

    GrupoEstudo(String tema){
        this.alunos = new ArrayList<Aluno>();
    }

    public boolean cadastrarAluno(Aluno aluno){
        if(aluno == null)
            return false;
        else{
            if (this.alunos.contains(aluno)) return false;
            this.alunos.add(aluno); return true;
        }
    }


}
