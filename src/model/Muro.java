package model;

public class Muro extends Personagem {
	
	private int coluna = 9;

	public Muro(String nome, int codigoJogador, int pontosVida) {
		super(nome, codigoJogador, pontosVida);
	}

	public int getColuna() {
		return coluna;
	}


}