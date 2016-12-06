package model;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Personagem  implements Jogada {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pontosVida;
	private int pontosAtaque;
	private boolean acaoDoTurno;
	private boolean longoAlcance;
	private String nome;
	private int codigoJogador;

	public Personagem(String nome, int codigoJogador, int pontosVida, int pontosAtaque, boolean acaoDoTurno,
			boolean longoAlcance) {
		this.pontosVida = pontosVida;
		this.pontosAtaque = pontosAtaque;
		this.acaoDoTurno = acaoDoTurno;
		this.longoAlcance = longoAlcance;
		this.nome = nome;
		this.codigoJogador = codigoJogador;
	}
	
	//construtor para o muro
	public Personagem(String nome, int codigoJogador, int pontosVida) {
		this.nome = nome;
		this.codigoJogador = codigoJogador;
		this.pontosVida = pontosVida;
	}

	public int recebeDano(int pontosAtaque) {

		this.setPontosVida(this.pontosVida - pontosAtaque);

		return this.pontosVida;
	}

	public int getCodigoJogador() {
		return this.codigoJogador;
	}

	public void setCodigoJogador(int codigoJogador) {
		this.codigoJogador = codigoJogador;
	}

	public void setPontosVida(int pontosVida) {
		this.pontosVida = pontosVida;
	}

	public int getPontosVida() {
		return pontosVida;
	}

	public int getPontosAtaque() {
		return pontosAtaque;
	}

	public void setPontosAtaque(int pontosAtaque) {
		this.pontosAtaque = pontosAtaque;
	}

	public boolean getAcaoDoTurno() {
		return acaoDoTurno;
	}

	public void setAcaoDoTurno(boolean acaoDoTurno) {
		this.acaoDoTurno = acaoDoTurno;
	}

	public boolean isLongoAlcance() {
		return longoAlcance;
	}

	public void setLongoAlcance(boolean longoAlcance) {
		this.longoAlcance = longoAlcance;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}