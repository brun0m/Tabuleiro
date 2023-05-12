package jogo;


public class Jogador extends Pinos {
	private String tipo;
	private int rodadas;
	
	public Jogador(String cor, String tipo) {
		super(cor);
		this.setTipo(tipo);
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
		return "Jogador [tipo=" + tipo + ", cor=" + cor + ", casa=" + casa + "]";
	}
	
	

}
