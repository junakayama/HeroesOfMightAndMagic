package model;

public class Posicao {

//	private boolean ocupada;
	private int codigo;
	private Personagem ocupante;
	private boolean castelo;
	private boolean muro;

	public Posicao(int codigo) {
		this.codigo = codigo;
		this.ocupante = null;
		this.castelo = false;
		this.muro = false;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public boolean isMuro() {
		return muro;
	}

	public void setMuro(boolean muro) {
		this.muro = muro;
	}
	
	
	//TUDO ISSO PODE SER SUBSTITUIDO APENAS PELA VERIFICA��O DE OCUPANTE
	
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