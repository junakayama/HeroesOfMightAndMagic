package view;

import java.util.ArrayList; 

import rede.AtorNetGames;


import control.Partida;
import model.Jogador;
import model.Posicao;

public class AtorJogador{

	private TelaPrincipal tela;
	private Partida partida;
	private AtorNetGames atorNetGames;
	private String idUsuario;
	
	public AtorJogador(){
		this.tela = new TelaPrincipal(this);
		this.partida = new Partida(this);
		this.atorNetGames = new AtorNetGames(this);
	}
	
	public void conectar() {
		tela.btConectar();
		String servidor = solicitarNome();
		String nomeJogador = solicitarNome();
		boolean conectou = atorNetGames.conectar(servidor, nomeJogador);
		
		if(conectou){
			notificarConexaoEstabelecida();
		} else {
			notificarFalhaDesconexao();
		}
	}

	public void notificarConexaoEstabelecida() {
		// TODO - implement AtorJogador.notificarConexaoEstabelecida
		throw new UnsupportedOperationException();
	}

	public void desconectar() {
		atorNetGames.desconectar();
		
	}

	public void notificarDesconexao() {
		// TODO - implement AtorJogador.notificarDesconexao
		throw new UnsupportedOperationException();
	}

	public void iniciarNovaPartida() {
		this.partida = new Partida(this);
		String idAdversario = atorNetGames.getNicknameAdversario();
		this.partida.criarJogadores(idUsuario, idAdversario);
	}

	public String solicitarNome() {
		return tela.solicitaNome();
	}

	public void iniciarPartida() {
		tela.btIniciarPartida();
		this.partida = new Partida(this);
		partida.iniciarPartida();
		tela.btIniciarPartida();
	}

	public void passarTurnoJogadorAtual() {
		this.partida.passarTurno();
	}

	/**
	 * 
	 * @param posicaoAtual
	 * @param posicaoDestino
	 * @throws Exception 
	 */
	public void jogar(int posicaoAtual, int posicaoDestino) throws Exception {
		System.out.println("entrou no jogar do ator jogador uhul");
		this.partida.jogar(posicaoAtual, posicaoDestino);
	}

	public void notificarVencedor(Jogador jogador) {
		tela.notificaVencedor();		
	}

	public void notificarErroPersonagem() {
		// TODO - implement AtorJogador.notificarErroPersonagem
		throw new UnsupportedOperationException();
	}

	public void notificarErroTurno() {
		tela.notificaErroTurno();
		
	}

	public void notificarErroInstancia() {
		tela.notificaErroInstancia();
	}

	/**
	 * 
	 * @param tabuleiro
	 */
	public void receberJogada(Partida partidaAtualizada) {
		Jogador jogadorTroca1 = partidaAtualizada.getJogador2();
		jogadorTroca1.setTurno(true);
		this.partida.setJogador1(jogadorTroca1);
		Jogador jogadorTroca2 = partidaAtualizada.getJogador1();
		jogadorTroca2.setTurno(false);
		this.partida.setJogador2(jogadorTroca2);
		
		ArrayList<Posicao> posicoesTroca = partidaAtualizada.getTabuleiro().getPosicoes();
		this.partida.getTabuleiro().setPosicoes(posicoesTroca);
		
		if(this.partida.getJogador2().isVencedor()) {
			notificarVencedor(this.partida.getJogador2());
			this.partida.setPartidaEmAndamento(false);
		}
	}

	public void notificarFalhaDesconexao() {
		tela.notificaErroDesconectado();
	}

	public void notificarDesconectado() {
	tela.notificaDesconectado();
	}

	public TelaPrincipal getTela() {
		return tela;
	}

	public void setTela(TelaPrincipal tela) {
		this.tela = tela;
	}
	
	public Partida getPartida(){
		return partida;
	}

}