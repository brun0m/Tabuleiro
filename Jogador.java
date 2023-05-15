package jogo;

import java.util.Random;

public class Jogador extends Pinos {
	private String tipo;
	private int rodadas;
	
	public Jogador(String cor) {
		super(cor);
		this.rodadas = 0;
		Random a1 = new Random();
		int valor = a1.nextInt(3);
		switch(valor) {
			case 0:
				this.setTipo("Sortudo");
				break;
			case 1:
				this.setTipo("Azarado");
				break;
			case 2:
				this.setTipo("Normal");
				break;
		}
	}
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getRodadas() {
		return rodadas;
	}


	public void setRodadas(int rodadas) {
		this.rodadas = rodadas;
	}


	@Override
	public String toString() {
		return "Jogador [tipo=" + tipo + ", cor=" + cor + ", casa=" + casa + 
				", rodadas=" + rodadas + "]";
	}
	
	

}
