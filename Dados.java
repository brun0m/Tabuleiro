package jogo;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Dados {
	private Jogador jogando;
	private int qntdjogadores = 6;
	private int contador = 0;
	private int valor;
	private int valor2;
	ArrayList<Jogador> Jogando;
	private Scanner tom;
	private int contaJogadas = 0;
	
	public Dados() {
		this.Jogando = new ArrayList<>();
	}
	
	public void InscricaoJogadores(Jogador j) {
		if(this.getContador() <= this.getQntdjogadores()) {
			this.Jogando.add(j);
			this.setContador(this.getContador() + 1);
		} else {
			System.out.println("Não pode ter mais que 6 jogadores!");
		}
	}
	
	public void jogarDados(Jogador j) {
		this.jogando = j;
		int soma = 0;
		if(this.getContador() < 2) {
			System.out.println("Número de jogadores abaixo do permitido, "
					+ "inscreva mais jogadores");
		} else if(Jogando.contains(j)){
			for(int i = 0; i < Jogando.size(); i++) {
				if(Jogando.get(i).getSemjogar() == 0 
						&& Jogando.get(i).getCor().equals(j.getCor())) {
					if(Jogando.get(i).getTipo().equals("Sortudo")) {
						while(soma < 7) {
							Random a1 = new Random();
							Random a2 = new Random();
							valor = a1.nextInt(6);
							valor2 = a2.nextInt(6);
							soma = valor + valor2;
						}
						Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
						Jogando.get(i).setRodadas(Jogando.get(i).getRodadas() + 1);
						contaJogadas++;
						CasasEspeciais(i);
						verificarRodada(i);
					} else if(Jogando.get(i).getTipo().equals("Normal")) {
						Random a1 = new Random();
						Random a2 = new Random();
						valor = a1.nextInt(1,6);
						valor2 = a2.nextInt(1,6);
						soma = valor + valor2;
						Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
						Jogando.get(i).setRodadas(Jogando.get(i).getRodadas() + 1);
						contaJogadas++;
						CasasEspeciais(i);
						verificarRodada(i);
					} else {
						soma = 8;
						while(soma > 7) {
							Random a1 = new Random();
							Random a2 = new Random();
							valor = a1.nextInt(1,6);
							valor2 = a2.nextInt(1,6);
							soma = valor + valor2;
						}
						Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
						Jogando.get(i).setRodadas(Jogando.get(i).getRodadas() + 1);
						contaJogadas++;
						CasasEspeciais(i);
						verificarRodada(i);
					}
				}
				else if(Jogando.get(i).getSemjogar() > 0 
						&& Jogando.get(i).getCor().equals(j.getCor())){
					System.out.println("Jogador " + Jogando.get(i).getCor() + " ficará " +
							Jogando.get(i).getSemjogar() + 
							" rodada(s) sem jogar, rodada pulada!");
					Jogando.get(i).setRodadas(Jogando.get(i).getRodadas() + 1);
					contaJogadas++;
					CasasEspeciais(i);
					verificarRodada(i);
				}
			}
		}
	}
	
	protected void jogarNovamente(int i) {
		int soma = 0;
		if(Jogando.get(i).getTipo().equals("Sortudo")) {
			while(soma < 7) {
				Random a1 = new Random();
				Random a2 = new Random();
				valor = a1.nextInt(1,6);
				valor2 = a2.nextInt(1,6);
				soma = valor + valor2;
			}
			Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
			CasasEspeciais(i);
		} else if(this.jogando.getTipo().equals("Normal")) {
			Random a1 = new Random();
			Random a2 = new Random();
			valor = a1.nextInt(1,6);
			valor2 = a2.nextInt(1,6);
			soma = valor + valor2;
			Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
			CasasEspeciais(i);
		} else {
			soma = 8;
			while(soma > 7) {
				Random a1 = new Random();
				Random a2 = new Random();
				valor = a1.nextInt(1,6);
				valor2 = a2.nextInt(1,6);
				soma = valor + valor2;
			}
			Jogando.get(i).setCasa(Jogando.get(i).getCasa() + soma);
			CasasEspeciais(i);
		}
		
	}

	protected void CasasEspeciais(int i) {
		if(Jogando.get(i).getCasa() == 10 || Jogando.get(i).getCasa() == 15 || 
				Jogando.get(i).getCasa() == 38) {
			if(Jogando.get(i).getSemjogar() > 0) {
				Jogando.get(i).setSemjogar(Jogando.get(i).getSemjogar() - 1);
			} else {
				Jogando.get(i).setSemjogar(Jogando.get(i).getSemjogar() + 1);
				System.out.println("O jogador " + Jogando.get(i).getCor() + 
						" ficará 1 rodada sem jogar!");
			}
		}
		
		else if(Jogando.get(i).getCasa() == 13) {
			Random a1 = new Random();
			int res = a1.nextInt(3);
			switch(res) {
				case 0:
					Jogando.get(i).setTipo("Sortudo");
					System.out.println("O tipo do jogador " + Jogando.get(i).getCor() + 
							" foi alterado pra " + Jogando.get(i).getTipo());
					break;
				case 1:
					Jogando.get(i).setTipo("Normal");
					System.out.println("O tipo do jogador " + Jogando.get(i).getCor() + 
							" foi alterado pra " + Jogando.get(i).getTipo());
					break;
				case 2:
					Jogando.get(i).setTipo("Azarado");
					System.out.println("O tipo do jogador " + Jogando.get(i).getCor() + 
							" foi alterado pra " + Jogando.get(i).getTipo());
					break;
			}
		}
		
		else if(Jogando.get(i).getCasa() == 5 || Jogando.get(i).getCasa() == 15 
				|| Jogando.get(i).getCasa() == 30) {
			if(Jogando.get(i).getTipo().equals("Azarado")) {
				System.out.println("O jogador " + Jogando.get(i).getCor() + 
						" é Azarado, então não avança nenhuma casa");
			}
			else {
				Jogando.get(i).setCasa(Jogando.get(i).getCasa() + 3);
				System.out.println("O jogador " + Jogando.get(i).getCor() + 
						" avançou 3 casas!");
			}
		}
		
		else if(Jogando.get(i).getCasa() == 17 || Jogando.get(i).getCasa() == 27) {
			System.out.println("O jogador da cor " + Jogando.get(i).getCor() + 
					"parou na casa " + Jogando.get(i).getCasa());
			System.out.println("Escolha a cor de um competidor "
					+ "para voltar ao início(Digite com inicial maiúscula");
			System.out.println("--------------------STATUS DA PARTIDA"
					+ "--------------------");
			for(int l = 0; l < Jogando.size(); l++) {
				System.out.println(Jogando.get(l).toString());		
			}
			System.out.println("");
			tom = new Scanner(System.in);
			String c = tom.nextLine();
			voltandoInicio(c);
			
		}
		
		else if(Jogando.get(i).getCasa() == 20 || Jogando.get(i).getCasa() == 35) {
			trocandoInicio(i);
		}
		
		else if(Jogando.get(i).getCasa() >= 40) {
			System.out.println("O jogador " + Jogando.get(i).getCor() + 
					"venceu a partida!");
			System.out.println("Resetando...");
			//Comando pra resetar tudo e mostrar relatorio
		}
		
		
	}
	
	protected void verificarRodada(int i) {
		if (valor == valor2) {
			System.out.println("Valores iguais! O jogador da cor " 
		+ Jogando.get(i).getCor() + " jogará novamente!");
			jogarNovamente(i);
		}
		
		else if(contaJogadas % this.getContador() == 0) {
			System.out.println("------------------DADOS " + contaJogadas/this.getContador() 
					+ " rodada------------------");
			for(int l = 0; l < Jogando.size(); l++) {
				System.out.println(Jogando.get(l).toString());		
			}
			System.out.println(" ");
		}
	}
	
	protected void voltandoInicio(String n) {
		int somador = 0;
		for(int i = 0; i < Jogando.size(); i++) {
			if(Jogando.get(i).getCor().equals(n)) {
				somador++;
				Jogando.get(i).setCasa(0);
				System.out.println("O jogador da cor " + n + " voltou para o início");
			}
		}
		if(somador == 0) {
			System.out.println("Cor não presente no jogo ou digitada de forma errada,"
					+ " digite uma cor presente no jogo com inicial maiúscula");
			voltandoInicio(n);
		}
	}
	
	protected void trocandoInicio(int i) {
		int menor = 40;
		int pos = 0;
		for(int j = 0; j < Jogando.size(); j++) {
			if(Jogando.get(j).getCasa() < menor) {
				menor = Jogando.get(j).getCasa();
				pos = j;
			}
		}
		if(menor == 40) {
			System.out.println("O jogador da cor " + Jogando.get(i).getCor() +
					" já está na última colocação, então não trocará com ninguém!");
		} else {
			Jogando.get(pos).setCasa(Jogando.get(i).getCasa());
			Jogando.get(i).setCasa(menor);
			System.out.println("O jogador da cor " + Jogando.get(i).getCor() +
					" trocou de posição com o último jogador que era " + 
					Jogando.get(pos).getCor());
		}
	}
	
	public Jogador getJogando() {
		return jogando;
	}


	public void setJogando(Jogador jogando) {
		this.jogando = jogando;
	}

	public int getQntdjogadores() {
		return qntdjogadores;
	}

	public void setQntdjogadores(int qntdjogadores) {
		this.qntdjogadores = qntdjogadores;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
}
