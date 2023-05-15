package jogo;

public class Principal {

	public static void main(String[] args) {
		Jogador j[] = new Jogador[6];
		Dados d = new Dados();
		j[0] = new Jogador("Azul");
		j[1] = new Jogador("Vermelho");
		j[2] = new Jogador("Verde");
		j[3] = new Jogador("Amarelo");
		j[4] = new Jogador("Branco");
		j[5] = new Jogador("Preto");
		
		System.out.println("Seja bem vindo ao jogo de tabuleiro da CC!");
		System.out.println("Inscreva seus jogadores e vamos jogar!");
		
		d.InscricaoJogadores(j[0]);
		d.InscricaoJogadores(j[1]);
		d.InscricaoJogadores(j[2]);
		d.InscricaoJogadores(j[3]);
		
		d.jogarDados(j[0]);
		d.jogarDados(j[1]);
		d.jogarDados(j[2]);
		d.jogarDados(j[3]);
		
		d.jogarDados(j[0]);
		d.jogarDados(j[1]);
		d.jogarDados(j[2]);
		d.jogarDados(j[3]);
		
		d.jogarDados(j[0]);
		d.jogarDados(j[1]);
		d.jogarDados(j[2]);
		d.jogarDados(j[3]);
	}

}
