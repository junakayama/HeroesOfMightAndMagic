package NetGames;

import control.Partida;
import view.AtorJogador;

public class AtorNetGames {

	private AtorJogador atorJogador;
	private Proxy proxy;
	private boolean conectado;
	
	public String conectar( String servidor) {
		String nomeJogador = proxy.conectar(servidor);
		setConectado(true);
		return nomeJogador;
	}

	public void desconectar() {
		if(conectado){
			proxy.desconectar();
			setConectado(false);
			atorJogador.notificarDesconexao();
			
		} else {
			atorJogador.notificarDesconectado();
		}
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

	public boolean isConectado() {
		return conectado;
	}

	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}

}