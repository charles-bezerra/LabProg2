package lab4;

/**
 * Enum responsável por conter as diferentes mensagens que podem
 * ser retornadas nas funções de AlocarAlunoEmGrupo nas instancias
 * ControleDeAluno e GrupoDeEstudo
 */
public enum MensagensAlocarAluno {
    AlunoNaoEncontrado(1),
    GrupoNaoEncontrado(2),
    CadastradoComSucesso(3);

    private int opcao;

    MensagensAlocarAluno(int opcao){ this.opcao = opcao; }
    public int getOpcao(){ return this.opcao; }
}