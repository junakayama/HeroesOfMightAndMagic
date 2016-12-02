package control;

import model.Jogador;
import model.Personagem;
///import model.Posicao;
import model.Tabuleiro;
import view.AtorJogador;

public class Partida {

	private int numRodadas;
	private boolean emAndamento;
	private Tabuleiro tabuleiro;
	private AtorJogador atorJogador;
	private Jogador jogador1;
	private Jogador jogador2;
	
	public Partida(){
		atorJogador = new AtorJogador();
		numRodadas = 165;
		tabuleiro = new Tabuleiro();
	}

	public void iniciarPartida() {
		this.atorJogador.iniciarPartida();
		
	}

	public void notificaPartidaEmAndamento() {
		// TODO - implement Partida.notificaPartidaEmAndamento
		throw new UnsupportedOperationException();
	}

	public void notificaPartidaIniciada() {
		// TODO - implement Partida.notificaPartidaIniciada
		throw new UnsupportedOperationException();
	}

	
	
	public boolean isEmAndamento() {
		return this.emAndamento;
	}


	/**
	 * 
	 * @param isEmAndamento
	 */
	public void setPartidaEmAndamento(boolean isEmAndamento) {
		this.emAndamento = isEmAndamento;
	}

	/**
	 * 
	 * @param posicaoAtual
	 * @param posicaoDestino
	 */
	public void jogar(int posicaoAtual, int posicaoDestino) {
		// vai porra
		throw new UnsupportedOperationException();
	}

	public boolean verificaVencedor() {
		// deve existir?
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tabuleiro
	 */
	public void enviarJogada(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	/**
	 * 
	 * @param nickname
	 * @param nicknameAdversario
	 */
	public void criarJogadores(String nickname, String nicknameAdversario) {
		this.jogador1 = new Jogador(true, nickname,true,1);
		jogador1.carregarPersonagensAtaque();
		this.jogador2 = new Jogador(false, nicknameAdversario,false,2);
		jogador2.carregarPersonagensDefesa();
	}

	public void notificarPartidaEmAndamento() {
		// TODO - implement Partida.notificarPartidaEmAndamento
		throw new UnsupportedOperationException();
	}

	public void noticarPartidaIniciada() {
		// TODO - implement Partida.noticarPartidaIniciada
		throw new UnsupportedOperationException();
	}

	public int getNumRodadas() {
		return numRodadas;
	}

	public void setNumRodadas(int numRodadas) {
		this.numRodadas = numRodadas;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

}