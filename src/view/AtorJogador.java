package view;

import java.util.ArrayList; 

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

import rede.AtorNetGames;


import control.Partida;
import model.Jogador;
import model.Personagem;
import model.Posicao;

public class AtorJogador implements Jogada{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TelaPrincipal tela;
	private Partida partida;
	private AtorNetGames atorNetGames;
	private String idUsuario;
	
	public AtorJogador(){
		this.tela = new TelaPrincipal(this);
		this.partida = new Partida();
		this.atorNetGames = new AtorNetGames(this);
	}
	
	public void conectar(String nomeJogador, String servidor) throws JahConectadoException, NaoPossivelConectarException, ArquivoMultiplayerException {
		this.atorNetGames.conectar(servidor, nomeJogador);
	}

	public void notificarConexaoEstabelecida() {
		tela.notificar("Conexão Estabelecida com sucesso");
	}

	public void desconectar() {
		atorNetGames.desconectar();
		
	}
	
	
	
	public void enviarJogada(Partida partida) throws NaoJogandoException {
		this.atorNetGames.enviarJogada(partida);
	}

	public void notificarDesconexao1() {
		tela.notificar("Desconexão realizada com sucesso");
	}

	public void iniciarNovaPartida(Integer posicao) {
		tela.notificar("Partida iniciada com sucesso");
		
		this.partida = new Partida();
		String idAdversario = atorNetGames.getNicknameAdversario();
		this.partida.criarJogadores(idUsuario, idAdversario, posicao);
	}

	public String solicitarNome() {
		return tela.solicitaNome();
	}
	
	public String solicitarServidor() {
		return tela.solicitaServidor();
	}

	public void iniciarPartida() throws NaoConectadoException {
		atorNetGames.iniciarPartidaRede();
	}

	/**
	 * 
	 * @param posicaoAtual
	 * @param posicaoDestino
	 * @throws Exception 
	 */
	public void jogar(int posicaoAtual, int posicaoDestino) throws Exception {
		int verifica = this.partida.jogar(posicaoAtual, posicaoDestino);
		if(this.partida.verificaJogada()) {
			enviarJogada(this.partida);
		}
		if(verifica == 1) {
			this.tela.mataPersonagem(posicaoDestino);
		}
		if(verifica == 2) {
			this.tela.notificarAtaque(this.partida.getTabuleiro().getPosicoes().get(posicaoDestino).getOcupante().getPontosVida());
		}
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
		this.partida.setNumRodadas(this.partida.getNumRodadas()+1);
		
		if(this.partida.getNumRodadas() == this.partida.getNumTotalRodadas()){
			if(this.partida.getJogador1().isAtaque()) {
				this.partida.getJogador2().setVencedor(true);
			} else {
				this.partida.getJogador1().setVencedor(true);
			}
		}
		
		if(this.partida.getJogador2().isVencedor()) {
			tela.notificar("Defesa venceu, número máximo de rodadas atingido");
			this.partida.setPartidaEmAndamento(false);
		}
		
		Jogador jogadorTroca1 = partidaAtualizada.getJogador2();
		jogadorTroca1.setTurno(true);
		this.partida.setJogador1(jogadorTroca1);
		Jogador jogadorTroca2 = partidaAtualizada.getJogador1();
		jogadorTroca2.setTurno(false);
		this.partida.setJogador2(jogadorTroca2);
		
		for(Personagem p: this.partida.getJogador1().getTime()) {
			if(p.getAcaoDoTurno()){
				p.setAcaoDoTurno(false);
			}
		}
		
		ArrayList<Posicao> posicoesTroca = partidaAtualizada.getTabuleiro().getPosicoes();
		this.partida.getTabuleiro().setPosicoes(posicoesTroca);
		
		if(this.partida.getJogador2().isVencedor()) {
			notificarVencedor(this.partida.getJogador2());
			this.partida.setPartidaEmAndamento(false);
		}

		tela.atualizaTudo(partidaAtualizada);
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

	public void passarTurnoJogadorAtual() throws NaoJogandoException {
		this.partida.getJogador1().setTurno(false);
		enviarJogada(this.partida);
		tela.notificar("Sua vez de jogar!");
	}

}