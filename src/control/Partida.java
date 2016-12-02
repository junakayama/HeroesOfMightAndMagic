package control;

//import model.Posicao;
import model.Tabuleiro;

public class Partida {

	private int numRodadas;
	private boolean emAndamento;
	private Tabuleiro tabuleiro;

	public void iniciarPartida() {
		// TODO - implement Partida.iniciarPartida
		throw new UnsupportedOperationException();
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
	 * @param nickName
	 * @param nicknameAdversario
	 */
	public void criaJogadores(String nickName, String nicknameAdversario) {
		// TODO - implement Partida.criaJogadores
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isEmAndamento
	 */
	public void setPartidaEmAndamento(boolean isEmAndamento) {
		// TODO - implement Partida.setPartidaEmAndamento
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicaoAtual
	 * @param posicaoDestino
	 */
	public void jogar(int posicaoAtual, int posicaoDestino) {
		// TODO - implement Partida.jogar
		throw new UnsupportedOperationException();
	}

	public boolean verificaVencedor() {
		// TODO - implement Partida.verificaVencedor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tabuleiro
	 */
	public void enviarJogada(Tabuleiro tabuleiro) {
		// TODO - implement Partida.enviarJogada
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nickname
	 * @param nicknameAdversario
	 */
	public void criarJogadores(String nickname, String nicknameAdversario) {
		// TODO - implement Partida.criarJogadores
		throw new UnsupportedOperationException();
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