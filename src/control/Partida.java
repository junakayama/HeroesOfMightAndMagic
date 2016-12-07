package control;

import java.util.List;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;

import model.Jogador;
import model.Personagem;
import model.Posicao;

///import model.Posicao;
import model.Tabuleiro;

public class Partida implements Jogada{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numTotalRodadas;
	private boolean emAndamento;
	private Tabuleiro tabuleiro;
	private Jogador jogador1;
	private Jogador jogador2;
	private int numRodadas;

	public Partida() {
		numTotalRodadas = 15;
		numRodadas = 0;
		tabuleiro = new Tabuleiro();
		emAndamento = true;
	}

	public boolean isEmAndamento() {
		return this.emAndamento;
	}

	public void setPartidaEmAndamento(boolean isEmAndamento) {
		this.emAndamento = isEmAndamento;
	}

	public int jogar(int posicaoAtual, int posicaoDestino) throws Exception{
		Posicao posicaoAt = tabuleiro.getPosicoes().get(posicaoAtual);
		Personagem ocupante = posicaoAt.getOcupante();
		if(ocupante != null && !posicaoAt.isMuro()) {
			if(jogador1.isTurno()){
				int codigo = jogador1.getCodigo();
				int codigoJogador = ocupante.getCodigoJogador();

				if(codigo == codigoJogador) {
					
					if(ocupante.getAcaoDoTurno()){
						throw new Exception("Esse personagem já jogou nesse turno");
					}
					boolean ocupada = tabuleiro.isPosicaoOcupada(posicaoDestino);
					
					if(!ocupada) {
					verificaAndar(posicaoAtual, posicaoDestino);

						if(jogador1.isAtaque()) {
							if(tabuleiro.verificaCastelo(posicaoDestino)) {
								jogador1.setVencedor(true);
							}
						}		
					} else {
						Posicao posicaoDest = tabuleiro.getPosicoes().get(posicaoDestino);
						int codigoAdversario = jogador2.getCodigo();
						Personagem inimigo = posicaoDest.getOcupante();
						int codigoJogadorAdversario = inimigo.getCodigoJogador();
						if(codigoAdversario == codigoJogadorAdversario) {
							int pontosVida = verificaAtaque(posicaoAtual, posicaoDestino);
							
							if(pontosVida <= 0) {
								jogador2.getTime().remove(inimigo);
								tabuleiro.getPosicoes().get(posicaoDestino).setOcupante(null);
								tabuleiro.getPosicoes().get(posicaoDestino).setMuro(false);

								int tamanhoLista = jogador2.getTime().size();
								if(tamanhoLista == 0) {
									jogador1.setVencedor(true);
								}
								return 1;
							}
							return 2;
						}else {
							throw new Exception("Nao ataque seu proprio personagem");
						}
					}
				} else {
					throw new Exception("Personagem pertence ao adversario");
				}
			} else {
				throw new Exception("Espere sua vez de jogar");
			}
		} else {
			throw new Exception("Eh muro ou nao tem personagem");
		}
		return 0;
	}
	
	public boolean verificaJogada() throws NaoJogandoException {
		for(Personagem p: this.jogador1.getTime()) {
			if(!p.getAcaoDoTurno()){
				return false;
			}
		}
		return true;
	}

	public void verificaAndar(int posicaoAtual, int posicaoDestino) throws Exception {
		int deslocamento = Math.abs(posicaoDestino - posicaoAtual);
		if((deslocamento <= 4) || (deslocamento == 15) || (deslocamento == 30)) {
			if(this.tabuleiro.getPosicoes().get(posicaoDestino).isMuro()) {
				throw new Exception("Não pode andar no muro");
			} else if (!verificaMuro(posicaoAtual, posicaoDestino) && this.jogador1.isAtaque()) {
				throw new Exception("Não pode ultrapassar o muro ou andar mais que dois espaços");
			}
			tabuleiro.andar(posicaoAtual, posicaoDestino);
		} else {
			throw new Exception("Não pode andar mais que dois espaços");
		}
	}
	
	public boolean verificaMuro(int posicaoAtual, int posicaoDestino) {
		Integer[] posicoesProximas = new Integer[4];
		int direita = posicaoAtual + 1;
		int baixo = posicaoAtual + 15;
		int esquerda = posicaoAtual - 1;
		int cima = posicaoAtual - 15;
		if (direita >= 0 && direita <= 164 && tabuleiro.getPosicoes().get(direita).isMuro()) {// direita
			posicoesProximas[0] = 1;// S� pra mostrar que n�o est� vazia
		}
		if (baixo >= 0 && baixo <= 164 && tabuleiro.getPosicoes().get(baixo).isMuro()) {// baixo
			posicoesProximas[1] = 1;
		}
		if (esquerda >= 0 && esquerda <= 164 && tabuleiro.getPosicoes().get(esquerda).isMuro()) {// esquerda
			posicoesProximas[2] = 1;
		}
		if (cima >= 0 && cima <= 164 && tabuleiro.getPosicoes().get(cima).isMuro()) {// cima
			posicoesProximas[3] = 1;
		}
		
		int posicaoPossivel = posicaoAtual - posicaoDestino;
		
		if(Math.abs(posicaoPossivel) == 1 || Math.abs(posicaoPossivel) == 15) {
			return true;
		}
		
		if (Math.abs(posicaoPossivel) == 2 || Math.abs(posicaoPossivel) == 30) {
			if (posicoesProximas[0] == null && posicaoPossivel == -2) {// direita
				return true;
			}
			if (posicoesProximas[1] == null && posicaoPossivel == -30) {// baixo
				return true;
			}
			if (posicoesProximas[2] == null && posicaoPossivel == 2) {// esquerda
				return true;
			}
			if (posicoesProximas[3] == null && posicaoPossivel == 30) {// cima
				return true;
			}
		}
		return false;
	}

	public void criarJogadores(String idUsuario, String idAdversario, Integer posicao) {
		if(posicao == 1) {
			this.jogador1 = new Jogador(true, idUsuario, true, 1);
			jogador1.carregarPersonagensAtaque();
			List<Personagem> ataque = jogador1.getTime();
			this.jogador2 = new Jogador(false, idAdversario, false, 2);
			jogador2.carregarPersonagensDefesa();
			List<Personagem> defesa = jogador2.getTime();
			tabuleiro.carregarPersonagens(ataque, defesa);
		} else {
			this.jogador1 = new Jogador(false, idAdversario, false, 1);
			jogador1.carregarPersonagensDefesa();
			List<Personagem> defesa = jogador1.getTime();
			this.jogador2 = new Jogador(true, idUsuario, true, 2);
			jogador2.carregarPersonagensAtaque();
			List<Personagem> ataque = jogador2.getTime();
			tabuleiro.carregarPersonagens(ataque, defesa);
		}
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
	
	public Jogador getJogador1(){
		return jogador1;
	}
	
	public void setJogador1(Jogador jogador) {
		this.jogador1 = jogador;
	}
	
	public Jogador getJogador2(){
		return jogador2;
	}
	
	public void setJogador2(Jogador jogador) {
		this.jogador2 = jogador;
	}
	

	public int verificaAtaque(int posicaoAtual, int posicaoDestino) throws Exception{
		Personagem personagem = tabuleiro.getPosicoes().get(posicaoAtual).getOcupante();
		int ret;
		int deslocamento = Math.abs(posicaoDestino - posicaoAtual);
		int modulo = deslocamento % 15;
		if(deslocamento == 1 || deslocamento == 15 ) {
			ret = tabuleiro.atacar(posicaoAtual, posicaoDestino);
			return ret;
		} else {
			if(personagem.isLongoAlcance()) {
				if(deslocamento <= 8 || modulo == 0) {
					ret = tabuleiro.atacar(posicaoAtual, posicaoDestino);
					return ret;
				}
			}
		}
		throw new Exception("Não pode atacar, personagem adversário está muito longe");
	}

	public int getNumTotalRodadas() {
		return numTotalRodadas;
	}

	public void setNumTotalRodadas(int numTotalRodadas) {
		this.numTotalRodadas = numTotalRodadas;
	}
}