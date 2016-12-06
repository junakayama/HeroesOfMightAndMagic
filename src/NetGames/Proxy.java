package NetGames;

import view.TelaPrincipal;

public class Proxy {

	/**
	 * 
	 * @param nickname
	 * @param servidor
	 */
	private TelaPrincipal tela;
	
	public String conectar(String servidor) {
		String nome =  tela.solicitaNome();
		return nome;
	}

	public boolean desconectar() {
		// TODO - implement Proxy.desconectar
		throw new UnsupportedOperationException();
	}

	public void iniciarPartida() {
		// TODO - implement Proxy.iniciarPartida
		throw new UnsupportedOperationException();
	}

}