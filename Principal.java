package jogo;

public class Principal {

	public static void main(String[] args) {
		Jogador j[] = new Jogador[2];
		Dados d = new Dados();
		j[0] = new Jogador("Azul", "Sortudo");
		j[1] = new Jogador("Vermelho", "Normal");
		d.jogarDados(j[0]);
		System.out.println(j[0].toString());
	}

}
