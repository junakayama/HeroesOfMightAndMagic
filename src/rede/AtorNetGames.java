package rede;

import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import control.Partida;
import view.AtorJogador;

public class AtorNetGames implements OuvidorProxy{

	private AtorJogador atorJogador;
	private Proxy proxy;
	private boolean conectado;
	
	public AtorNetGames(AtorJogador atorJogador) {
		super();
		this.atorJogador = atorJogador;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
	}
	
	public boolean conectar(String servidor, String nome) {
		try {
			proxy.conectar(servidor, nome);
		} catch (JahConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador.getTela(), e.getMessage());
			e.printStackTrace();
			return false;
		} catch (NaoPossivelConectarException e) {
			JOptionPane.showMessageDialog(atorJogador.getTela(), e.getMessage());
			e.printStackTrace();
			return false;
		} catch (ArquivoMultiplayerException e) {
			JOptionPane.showMessageDialog(atorJogador.getTela(), e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
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

	public void iniciarNovaPartida() {
		atorJogador.iniciarNovaPartida();
	}

	public void iniciarPartida() {
		try {
			proxy.iniciarPartida(new Integer(2));
		} catch (NaoConectadoException e) {
			JOptionPane.showMessageDialog(atorJogador.getTela(), e.getMessage());
			e.printStackTrace();
		}
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

	public void iniciarNovaPartida(Integer posicao) {
		// TODO Auto-generated method stub
		
	}

	public void finalizarPartidaComErro(String message) {
		// TODO Auto-generated method stub
		
	}

	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub
		
	}

	public void receberJogada(Jogada jogada) {
		// TODO Auto-generated method stub
		
	}

	public void tratarConexaoPerdida() {
		// TODO Auto-generated method stub
		
	}

	public void tratarPartidaNaoIniciada(String message) {
		// TODO Auto-generated method stub
		
	}

}