package model;

import java.util.ArrayList;

public class Tabuleiro {

	private ArrayList<Posicao> posicoes;
	private Posicao posicaoAtual;
	private Posicao posicaoDestino;
	private Personagem ocupante;
	private Personagem inimigo;
	
	public Tabuleiro() {
		super();
	}

	/**
	 * 
	 * @param posicao
	 */
	public boolean isPosicaoOcupada(int posicao) {
		boolean ocupada;
		ocupada = posicoes.get(posicao).isOcupada();
		return ocupada;
	}

	/**
	 * 
	 * @param posicaoAtual
	 * @param posicaoDestino
	 */
	public void andar(int posicaoAtual, int posicaoDestino) {
		// TODO - implement Tabuleiro.andar
		throw new UnsupportedOperationException();
	}

	public void atualizarInformacoes() {
		// TODO - implement Tabuleiro.atualizarInformacoes
		throw new UnsupportedOperationException();
	}

	public void criarPosicoes() {
		// TODO - implement Tabuleiro.criarPosicoes
		throw new UnsupportedOperationException();
	}

	public void posicionarPersonagens() {
		// TODO - implement Tabuleiro.posicionarPersonagens
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicaoAtual
	 * @param posicaoDestino
	 */
	public void jogar(Posicao posicaoAtual, Posicao posicaoDestino) {
		// TODO - implement Tabuleiro.jogar
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicaoAtual
	 */
	public Personagem buscaOcupante(int posicaoAtual) {
		setOcupante(posicoes.get(posicaoAtual).getOcupante());
		return getOcupante();
	}

	/**
	 * 
	 * @param posicaoAtual
	 * @param posicaoDestino
	 */
	public int atacar(Posicao posicaoAtual, Posicao posicaoDestino) {
		// TODO - implement Tabuleiro.atacar
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicao
	 */
	public boolean verificaCastelo(Posicao posicao) {
		// TODO - implement Tabuleiro.verificaCastelo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicaoDestino
	 */
	public Posicao atribuiInimigoPosicao(Posicao posicaoDestino) {
		// TODO - implement Tabuleiro.atribuiInimigoPosicao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicao
	 */
	public int verificaPontosAtaque(Posicao posicao) {
		// TODO - implement Tabuleiro.verificaPontosAtaque
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicao
	 */
	public int verificaPontosVida(Posicao posicao) {
		// TODO - implement Tabuleiro.verificaPontosVida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicaoDestino
	 */
	public Posicao atribuiPersongaemPosicao(Posicao posicaoDestino) {
		// TODO - implement Tabuleiro.atribuiPersongaemPosicao
		throw new UnsupportedOperationException();
	}

	public Personagem getOcupante() {
		return ocupante;
	}

	public void setOcupante(Personagem ocupante) {
		this.ocupante = ocupante;
	}

	public Personagem getInimigo() {
		return inimigo;
	}

	public void setInimigo(Personagem inimigo) {
		this.inimigo = inimigo;
	}
}