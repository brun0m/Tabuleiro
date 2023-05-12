package jogo;

import java.util.Random;

public class Dados {
	private Jogador jogando;
	private int valor;
	private int valor2;
	
	public void jogarDados(Jogador j) {
		this.jogando = j;
		int soma = 0;
		if(this.jogando.getSemjogar() == 0) {
			if(this.jogando.getTipo().equals("Sortudo")) {
				while(soma < 7) {
					Random a1 = new Random();
					Random a2 = new Random();
					valor = a1.nextInt(1,6);
					valor2 = a2.nextInt(1,6);
					soma = valor + valor2;
				}
				this.jogando.setCasa(this.jogando.getCasa() + soma);
			} else if(this.jogando.getTipo().equals("Normal")) {
				Random a1 = new Random();
				Random a2 = new Random();
				valor = a1.nextInt(1,6);
				valor2 = a2.nextInt(1,6);
				soma = valor + valor2;
				this.jogando.setCasa(this.jogando.getCasa() + soma);
			} else {
				soma = 8;
				while(soma > 7) {
					Random a1 = new Random();
					Random a2 = new Random();
					valor = a1.nextInt(1,6);
					valor2 = a2.nextInt(1,6);
				}
				this.jogando.setCasa(this.jogando.getCasa() + soma);
				}
			
		} else {
			System.out.println("Jogador " + this.jogando.toString() + " ficará " +
		this.jogando.getSemjogar() + " rodada(s) sem jogar, rodada pulada!");
		}
		
		CasasEspeciais();
	}

	public void CasasEspeciais() {
		if(this.jogando.getCasa() == 10 || this.jogando.getCasa() == 15 || 
				this.jogando.getCasa() == 38) {
			if(this.jogando.getSemjogar() > 0) {
				this.jogando.setSemjogar(this.jogando.getSemjogar() - 1);
			} else {
				this.jogando.setSemjogar(this.jogando.getSemjogar() + 1);
				System.out.println("O jogador ficará 1 rodada sem jogar!");
			}
		}
		
		else if(this.jogando.getCasa() == 13) {
			Random a1 = new Random();
			int res = a1.nextInt(3);
			switch(res) {
				case 0:
					this.jogando.setTipo("Sortudo");
				case 1:
					this.jogando.setTipo("Normal");
				case 2:
					this.jogando.setTipo("Azarado");
			}
			System.out.println("O tipo do jogador " + this.jogando.getCor() + 
					" foi alterado pra " + this.jogando.getTipo());
		}
		
		else if(this.jogando.getCasa() == 5 || this.jogando.getCasa() == 15 
				|| this.jogando.getCasa() == 30) {
			if(this.jogando.getTipo().equals("Azarado")) {
				System.out.println("O jogador " + this.jogando.getCor() + 
						" é Azarado, então não avança nenhuma casa");
			}
			else {
				this.jogando.setCasa(this.jogando.getCasa() + 3);
				System.out.println("O jogador " + this.jogando.getCor() + 
						" avançou 3 casas!");
			}
		}
		
		else if(this.jogando.getCasa() >= 40) {
			System.out.println("O jogador " + this.jogando.getCor() + 
					"venceu a partida!");
			System.out.println("Resetando...");
			//Comando pra resetar tudo e mostrar relatorio
		}
		if (valor == valor2) {
			jogarDados(this.jogando);
		}
		
	}
	public Jogador getJogando() {
		return jogando;
	}


	public void setJogando(Jogador jogando) {
		this.jogando = jogando;
	}
}
