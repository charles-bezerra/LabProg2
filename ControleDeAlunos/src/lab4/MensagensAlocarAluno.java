package lab4;

/**
 * Enum responsável por conter as diferentes mensagens que podem
 * ser retornadas nas funções de AlocarAlunoEmGrupo nas instancias
 * ControleDeAluno e GrupoDeEstudo
 */
public enum MensagensAlocarAluno {
	/**
	 * Retornado quando o aluno não está cadastrado
	 */
    AlunoNaoEncontrado(1),
    
	/**
	 * Retornado quando o grupo não está cadastrado
	 */
    GrupoNaoEncontrado(2),
    
    /**
     * Retorado quando o cadastro é realizado com sucesso
     */
    CadastradoComSucesso(3);

    private int opcao;

    MensagensAlocarAluno(int opcao){ this.opcao = opcao; }
    public int getOpcao(){ return this.opcao; }
}