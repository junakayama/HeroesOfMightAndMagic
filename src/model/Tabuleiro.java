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

	
	public boolean isPosicaoOcupada(int posicao) {
		boolean ocupada;
		posicaoDestino=posicoes.get(posicao);
		ocupada = posicaoDestino.isOcupada();
		return ocupada;
	}

	public void andar(int posicaoAtual, int posicaoDestino) {
		this.posicaoDestino.setOcupante(ocupante);
		this.posicaoAtual.setOcupante(null);
		ocupante.setAcaoDoTurno(true);
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

	public void jogar(Posicao posicaoAtual, Posicao posicaoDestino) {
		// TODO - implement Tabuleiro.jogar
		throw new UnsupportedOperationException();
	}

	public Personagem buscaOcupante(int posicao) {
		posicaoAtual=posicoes.get(posicao);
		setOcupante(posicaoAtual.getOcupante());
		return getOcupante();
	}

	public int atacar(Posicao posicaoAtual, Posicao posicaoDestino) {
		return 1;
	}


	public boolean verificaCastelo(int posicao) {
		return posicoes.get(posicao).isCastelo();
	}


	public Posicao atribuiInimigoPosicao(int posicaoDestino) {
		inimigo = posicoes.get(posicaoDestino).getPersonagem();
		return posicoes.get(posicaoDestino);
		
	}

	public Posicao atribuiPersongaemPosicao(int posicaoDestino) {
		posicoes.get(posicaoDestino).setPersonagem(null);
		ocupante.setAcaoDoTurno(true);
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