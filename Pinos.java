package jogo;


public class Pinos {
	protected String cor;
	protected int casa;
	protected int semjogar;
	
	public Pinos(String c) {
		this.cor = c;
		this.casa = 0;
	}
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getCasa() {
		return casa;
	}

	public void setCasa(int casa) {
		this.casa = casa;
	}

	public int getSemjogar() {
		return semjogar;
	}

	public void setSemjogar(int semjogar) {
		this.semjogar = semjogar;
	}
	
}
