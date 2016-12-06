package rede;

import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import control.Partida;
import view.AtorJogador;

public class AtorNetGames implements OuvidorProxy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AtorJogador atorJogador;
	private Proxy proxy;
	private boolean conectado;
	
	public AtorNetGames(AtorJogador atorJogador) {
		super();
		this.atorJogador = atorJogador;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
	}
	
	public void conectar(String servidor, String nome) throws JahConectadoException, NaoPossivelConectarException, ArquivoMultiplayerException {
		proxy.conectar(servidor, nome);
	}

	public void desconectar() {
		if(conectado){
			try {
				proxy.desconectar();
				setConectado(false);
				atorJogador.notificarDesconexao();
			} catch (NaoConectadoException e) {
				JOptionPane.showMessageDialog(atorJogador.getTela(), e.getMessage());
				e.printStackTrace();
			}
			
		} else {
			atorJogador.notificarDesconectado();
		}
	}
	
	public void iniciarPartidaRede() throws NaoConectadoException {
		proxy.iniciarPartida(new Integer(2));
	}
	
	public void enviarJogada(Partida partida) throws NaoJogandoException {
		Jogada jogada = (Jogada) partida;
		proxy.enviaJogada(jogada);
	}

	public String getNicknameAdversario(String idUsuario) {
		String aux1 = proxy.obterNomeAdversario(new Integer(1));
		String aux2 = proxy.obterNomeAdversario(new Integer(2));;
		if (aux1.equals(idUsuario)){
			return aux2;
		} else {
			return aux1;
		}
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

	public void tratarPartidaNaoIniciada(String message) {
		// TODO Auto-generated method stub
		
	}

	public String getNicknameAdversario() {
		return proxy.obterNomeAdversarios().get(0);
	}

	public void iniciarNovaPartida(Integer posicao) {
		atorJogador.iniciarNovaPartida(posicao);
	}

	public void finalizarPartidaComErro(String message) {
		// TODO Auto-generated method stub
		
	}

	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub
		
	}

	public void receberJogada(Jogada jogada) {
		Partida partida = (Partida) jogada;
		atorJogador.receberJogada(partida);
	}

	public void tratarConexaoPerdida() {
		// TODO Auto-generated method stub
		
	}

}