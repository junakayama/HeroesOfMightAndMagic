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
	
	public void conectar(String nomeJogador, String servidor) {
		tela.btConectar();

		boolean conectou = atorNetGames.conectar(servidor, nomeJogador);
		
		if(conectou){
			tela.btConectar();
			notificarConexaoEstabelecida();
		} else {
			notificarFalhaConexao();
		}
	}

	public void notificarConexaoEstabelecida() {
		tela.notificar("Conexão Estabelecida com sucesso");
	}

	public void desconectar() {
		atorNetGames.desconectar();
		
	}


	public void notificarDesconexao1() {
		tela.notificar("Desconexão realizada com sucesso");
	}

	public void iniciarNovaPartida() {
		this.partida = new Partida(this);
		String idAdversario = atorNetGames.getNicknameAdversario();
		this.partida.criarJogadores(idUsuario, idAdversario);
	}

	public String solicitarNome() {
		return tela.solicitaNome();
	}
	
	public String solicitarServidor() {
		return tela.solicitaServidor();
	}

	public void iniciarPartida() {
		tela.btIniciarPartida();
		this.partida = new Partida(this);
		this.partida.criarJogadores(idUsuario, "luiza");
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
		this.partida.jogar(posicaoAtual, posicaoDestino);
	}

	public void notificarVencedor(Jogador jogador) {
		tela.notificar("Você venceu!!!");		
	}

	public void notificarErroPersonagem() {
		tela.notificar("Personagem errado");
	}

	public void notificarErroTurno() {
		tela.notificar("Turno errado");
		
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

	public void notificarFalhaConexao() {
		tela.notificar("Falha na conexão");
	}

	public void notificarDesconectado() {
		tela.notificar("Já está desconectado");
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

	public void notificaErroPassarMuro() {
		tela.notificar("Não pode passar o muro");
	}

	public void notificaAndamento() {
		tela.notificar("Partida em andamento");
		
	}

	public void notificaIniciada() {
		tela.notificar("Partida iniciada");
	}

	public void notificaErroAndarMuro() {
		tela.notificar("Erro ao andar no muro");
	}

	public void notificarDesconexao() {
		tela.notificar("Desconexão realizada com sucesso!");
		
	}

	public void notificaPoucoAlcance() {
		tela.notificar("Personagem não possui alcance suficiente");
	}

}