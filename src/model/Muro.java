package model;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Muro extends Personagem implements Jogada{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int coluna = 9;

	public Muro(String nome, int codigoJogador, int pontosVida) {
		super(nome, codigoJogador, pontosVida);
	}

	public int getColuna() {
		return coluna;
	}


}