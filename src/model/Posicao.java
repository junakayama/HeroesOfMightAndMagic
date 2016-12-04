package model;

public class Posicao {

//	private boolean ocupada;
	private int linha;
	private int coluna;
	private Personagem ocupante;
	private boolean castelo;

	public Posicao(int linha, int coluna, Personagem ocupante, boolean castelo) {
		super();
		this.linha = linha;
		this.coluna = coluna;
		this.ocupante = ocupante;
		this.castelo = castelo;
	}

	public int getLinha() {
		return this.linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return this.coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public Personagem getOcupante() {
		return this.ocupante;
	}

	public void setOcupante(Personagem ocupante) {
		this.ocupante = ocupante;
	}
	
	public boolean isCastelo() {
		return castelo;
	}

	public void setCastelo(boolean castelo) {
		this.castelo = castelo;
	}

	public int verificaPontosAtaque(Posicao posicao) {
		int pontosVidaDoPersonagem = ocupante.getPontosAtaque();
		return pontosVidaDoPersonagem;
	}

	public int verificaPontosVida(Posicao posicao) {
		int pontosVidaDoPersonagem = ocupante.getPontosVida();
		return pontosVidaDoPersonagem;
	}
	
	
	//TUDO ISSO PODE SER SUBSTITUIDO APENAS PELA VERIFICAÇÃO DE OCUPANTE
	
//	public boolean getOcupada() {
//		return this.ocupada;
//	}
//
//	public boolean isOcupada() {
//		// TODO - implement Posicao.isOcupada
//		throw new UnsupportedOperationException();
//	}
//
//	public void setPersonagem(Personagem ocupante) {
//		// TODO - implement Posicao.setPersonagem
//		throw new UnsupportedOperationException();
//	}
//
//	public Personagem getPersonagem() {
//		// TODO - implement Posicao.getPersonagem
//		throw new UnsupportedOperationException();
//	}
}