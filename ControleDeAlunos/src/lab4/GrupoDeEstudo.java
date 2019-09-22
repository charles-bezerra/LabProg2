package lab4;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representação de um grupo de estudos
 */
public class GrupoDeEstudo {
    /**
     * Guarda o nome do tema que identifica o grupo de estudos
     */
    private String tema;

    /**
     * Mapa que guarda os objetos de aluno
     */
    private Map<String, Aluno> alunos;

    /**
     * Lista que guarda a ordem que os Alunos foram cadastrados
     */
    private ArrayList<String> matriculaAlunos;

    /**
     * Atributo que recebe a quebra de linha adequada para  vários tipos de sistemas operacionais
     */
    private static final String LS = System.lineSeparator();

    /**
     * Contrutor padrão e único do grupo de estudo
     *
     * @param tema identificado do grupo de estudo
     */
    GrupoDeEstudo(String tema){
        this.tema = ValidaArgumentos.verificarString(tema,"tema");
        this.alunos = new HashMap<>();
        this.matriculaAlunos = new ArrayList<>();
    }

    /**
     * Método que adiciona um aluno no grupo de estudos
     *
     * @param aluno objeto do tipo Aluno
     * @return retorna se o processo foi realizado com sucesso ou não true/false
     */
    public boolean adicionarAluno(Aluno aluno){
        aluno = ValidaArgumentos.verificarAluno(aluno);

        if( this.alunos.containsKey( aluno.getMatricula() ) ) return false;

        this.alunos.put( aluno.getMatricula(), aluno );
        this.matriculaAlunos.add(aluno.getMatricula());
        return true;
    }

    /**
     * Método responsável por listar o grupo de estudos e os alunos que esse
     * grupo contém
     *
     * @return retorna a representação do grupo em String
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
