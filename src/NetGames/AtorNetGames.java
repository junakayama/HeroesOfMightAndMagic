package NetGames;

import control.Partida;
import view.AtorJogador;

public class AtorNetGames {

	private AtorJogador atorJogador;
	private Proxy proxy;
	
	public void conectar(String nickname, String servidor) {
		
	}

	public void desconectar() {
		proxy.desconectar();
	}

	public void iniciarNovaPartida() {
		atorJogador.iniciarNovaPartida();
	}

	public void iniciarPartida() {
		proxy.iniciarPartida();
	}

	public String getNicknameAdversario() {
		// TODO - implement AtorNetGames.getNicknameAdversario
		throw new UnsupportedOperationException();
	}

	public void receberJogada(Partida partida) {
		atorJogador.receberJogada(partida);
	}

	public AtorJogador getAtorJogador() {
		return atorJogador;
	}

	public void setAtorJogador(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
	}

	public Proxy getProxy() {
		return proxy;
	}

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

}