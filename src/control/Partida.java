package control;

import model.Jogador;
import model.Personagem;
import model.Posicao;

///import model.Posicao;
import model.Tabuleiro;
import view.AtorJogador;

public class Partida {

	private int numRodadas;
	private boolean emAndamento;
	private Tabuleiro tabuleiro;
	private AtorJogador atorJogador;
	private Jogador jogador1;
	private Jogador jogador2;

	public Partida() {
		numRodadas = 65; //que
		tabuleiro = new Tabuleiro();
	}

	public void iniciarPartida() {
		this.atorJogador.iniciarPartida();

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
	 * @param isEmAndamento
	 */
	public void setPartidaEmAndamento(boolean isEmAndamento) {
		this.emAndamento = isEmAndamento;
	}

	public void jogar(int posicaoAtual, int posicaoDestino) {
		Posicao posicaoAt = tabuleiro.verificarPosicao(posicaoAtual);
		Personagem ocupante = posicaoAt.getOcupante(); //wtf pq tem ocupante em tabuleiro
		int coluna = posicaoAt.getColuna();
		
		if(ocupante != null && coluna != 9) {
			if(jogador1.isTurno()){
				int codigo = jogador1.getCodigo();
				int codigoJogador = ocupante.getCodigoJogador();
				if(codigo == codigoJogador) {
					if(ocupante.getAcaoDoTurno()){
						//notifica esse tu j� usou renato
					}
					
					boolean ocupada = tabuleiro.isPosicaoOcupada(posicaoDestino);
					if(!ocupada) {
						tabuleiro.andar(posicaoAtual, posicaoDestino);
						if(jogador1.isAtaque()) {
							if(tabuleiro.verificaCastelo(posicaoDestino)) {
								jogador1.setVencedor(true);
								enviarJogada(tabuleiro);
							}
						}else{
							enviarJogada(tabuleiro);
						}
						
						
					} else {
						tabuleiro.atribuiInimigoPosicao(posicaoDestino);
						Posicao posicaoDest = tabuleiro.verificarPosicao(posicaoDestino);
						int codigoAdversario = jogador2.getCodigo();
						Personagem inimigo = posicaoDest.getOcupante();
						int codigoJogadorAdversario = inimigo.getCodigoJogador();
						if(codigoAdversario == codigoJogadorAdversario) {
							int pontosVida = tabuleiro.atacar(posicaoAtual, posicaoDestino);
							if(pontosVida <= 0) {
								tabuleiro.atribuiPersonagemPosicao(posicaoDestino);
								jogador2.getTime().remove(inimigo);
								int tamanhoLista = jogador2.getTime().size();
								if(tamanhoLista == 0){
									jogador1.setVencedor(true);
									enviarJogada(tabuleiro);
								}else {
									enviarJogada(tabuleiro);
								}
							}
						} else {
							//TROCA PERSONAGEM? NOTIFICA PRA ESCOLHER OUTRO?
						}
					}
				} else {
					//NOTIFICA QUE NÃO É DO JOGADOR ATUAL
				}
			} else {
				//NOTIFICA NÃO É TURNO
			}
		}
	}

	public boolean verificaVencedor() {
		// deve existir?
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tabuleiro
	 */
	public void enviarJogada(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro; //ENVIAR PARA O NETGAMES
	}

	/**
	 * 
	 * @param nickname
	 * @param nicknameAdversario
	 */
	public void criarJogadores(String nickname, String nicknameAdversario) {
		this.jogador1 = new Jogador(true, nickname, true, 1);
		jogador1.carregarPersonagensAtaque();
		this.jogador2 = new Jogador(false, nicknameAdversario, false, 2);
		jogador2.carregarPersonagensDefesa();
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