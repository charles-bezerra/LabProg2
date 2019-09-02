package tarefas;

public class MainTeste2 {
	public static void main(String[] args) {
		//criando atletas (nome, altura, peso e sexo biologico) com programa de exercícios vazio.
		Atleta abrantes = new Atleta("Jorge Abrantes", 1.72, 62, "Masculino");
		Atleta neymar = new Atleta("Neymar Junior", 1.74, 68, "Masculino");
		Atleta lima = new Atleta("Lima Gau", 1.65, 68, "Feminino");
		//adicionando exercicios (nome + calorias gastas) ao programa do atleta
		System.out.println("Deve ser true: "+neymar.adicionaExercicio("Futebol", 200));
		System.out.println("Deve ser true: 	"+neymar.adicionaExercicio("Corrida", 450));
		System.out.println("Deve ser true: 	"+neymar.adicionaExercicio("Futvolei", 250));
		System.out.println("Deve ser false: "+neymar.adicionaExercicio("Jiu-jitsu", 840));
		System.out.println("Deve ser true: 	"+abrantes.adicionaExercicio("Corrida", 450));
		System.out.println("Deve ser true: "+lima.adicionaExercicio("Danca",300));
		System.out.println("Deve ser true: 	"+lima.adicionaExercicio("Jiu-jitsu", 840));
		//gastando calorias com os exercícios do programa por X horas
		System.out.println("Deve ser 1350: "+abrantes.malha(3));
		System.out.println("Deve ser 5220: "+neymar.malha(3));
		System.out.println("Deve ser 3420: "+lima.malha(3));
		//calcula IMC
		System.out.println("Deve ser Intermediario: "+neymar.calculaIMC());
		System.out.println("Deve ser Intermediario: "+lima.calculaIMC());
		System.out.println("Deve ser Intermediario: "+abrantes.calculaIMC());
		//mostra as informações de cada atleta
		System.out.println(lima);
		System.out.println(neymar);
		System.out.println(abrantes);
	}
}