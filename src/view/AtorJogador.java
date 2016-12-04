package view;

import model.Posicao;
import model.Tabuleiro;

public class AtorJogador{

	private TelaPrincipal tela;
	
	public AtorJogador(){
		this.setTela(new TelaPrincipal(this));
	}
	
	public void conectar() {
		// TODO - implement AtorJogador.conectar
		throw new UnsupportedOperationException();
	}

	public void notificarConexaoEstabelecida() {
		// TODO - implement AtorJogador.notificarConexaoEstabelecida
		throw new UnsupportedOperationException();
	}

	public void desconectar() {
		// TODO - implement AtorJogador.desconectar
		throw new UnsupportedOperationException();
	}

	public void notificarDesconexao() {
		// TODO - implement AtorJogador.notificarDesconexao
		throw new UnsupportedOperationException();
	}

	public void iniciarNovaPartida() {
		// TODO - implement AtorJogador.iniciarNovaPartida
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nome
	 */
	public String solicitarNome(String nome) {
		// TODO - implement AtorJogador.solicitarNome
		throw new UnsupportedOperationException();
	}

	public void iniciarPartida() {
		// TODO - implement AtorJogador.iniciarPartida
		throw new UnsupportedOperationException();
	}

	public void passarTurnoJogadorAtual() {
		// TODO - implement AtorJogador.passarTurnoJogadorAtual
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posicaoAtual
	 * @param posicaoDestino
	 */
	public void jogar(Posicao posicaoAtual, Posicao posicaoDestino) {
		// TODO - implement AtorJogador.jogar
		throw new UnsupportedOperationException();
	}

	public void notificarVitoria() {
		// TODO - implement AtorJogador.notificarVitoria
		throw new UnsupportedOperationException();
	}

	public void notificarErroPersonagem() {
		// TODO - implement AtorJogador.notificarErroPersonagem
		throw new UnsupportedOperationException();
	}

	public void notificarErroTurno() {
		// TODO - implement AtorJogador.notificarErroTurno
		throw new UnsupportedOperationException();
	}

	public void notificarErroInstancia() {
		// TODO - implement AtorJogador.notificarErroInstancia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tabuleiro
	 */
	public void receberJogada(Tabuleiro tabuleiro) {
		// TODO - implement AtorJogador.receberJogada
		throw new UnsupportedOperationException();
	}

	public void notificarFalhaDesconexao() {
		// TODO - implement AtorJogador.notificarFalhaDesconexao
		throw new UnsupportedOperationException();
	}

	public void notificarDesconectado() {
		// TODO - implement AtorJogador.notificarDesconectado
		throw new UnsupportedOperationException();
	}

	public TelaPrincipal getTela() {
		return tela;
	}

	public void setTela(TelaPrincipal tela) {
		this.tela = tela;
	}

}