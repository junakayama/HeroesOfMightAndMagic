package control;

import java.util.List;

import model.Jogador;
import model.Personagem;
import model.Posicao;

///import model.Posicao;
import model.Tabuleiro;
import view.AtorJogador;
import view.TelaPrincipal;

public class Partida {

	private int numRodadas;
	private boolean emAndamento;
	private Tabuleiro tabuleiro;
	private Jogador jogador1;
	private Jogador jogador2;
	private AtorJogador ator;
	private TelaPrincipal tela;

	public Partida(AtorJogador ator) {
		numRodadas = 15;
		tabuleiro = new Tabuleiro();
		this.ator = ator;
		criarJogadores("nome1","nome2");
	}

	public void iniciarPartida() {
		if(emAndamento) {
			notificaPartidaEmAndamento();
		} else {
			setPartidaEmAndamento(true);
			notificaPartidaIniciada();
		}
	
	}

	public void notificaPartidaEmAndamento() {
		this.ator.getTela().notificaAndamento();
	}

	public void notificaPartidaIniciada() {
		this.ator.getTela().notificaIniciada();
	}

	public boolean isEmAndamento() {
		return this.emAndamento;
	}

	public void setPartidaEmAndamento(boolean isEmAndamento) {
		this.emAndamento = isEmAndamento;
	}

	public void jogar(int posicaoAtual, int posicaoDestino) throws Exception{
		Posicao posicaoAt = tabuleiro.getPosicoes().get(posicaoAtual);
		System.out.println(posicaoAt.getCodigo()+" ====== " + posicaoAtual);
		Personagem ocupante = posicaoAt.getOcupante();
		System.out.println(ocupante.getNome()+" jogando");
		if(ocupante != null && !posicaoAt.isMuro()) {
			System.out.println("verifica ocupante e muro uhul");
			if(jogador1.isTurno()){
				System.out.println("verifica turno uhul");
				int codigo = jogador1.getCodigo();
				int codigoJogador = ocupante.getCodigoJogador();
				System.out.println("fim verifica turno uhul");

				if(codigo == codigoJogador) {
					
					if(ocupante.getAcaoDoTurno()){
						throw new Exception("Esse personagem já jogou nesse turno");
					}
					System.out.println("verifica codigo jogador uhul");

					boolean ocupada = tabuleiro.isPosicaoOcupada(posicaoDestino);
					
					if(!ocupada) {
					tabuleiro.andar(posicaoAtual, posicaoDestino);
					this.verificaAndar(posicaoAtual, posicaoDestino);
						System.out.println("andouuuuuu");

						if(jogador1.isAtaque()) {
							System.out.println("verifica se eh ataque uhul");

							if(tabuleiro.verificaCastelo(posicaoDestino)) {
								jogador1.setVencedor(true);
								enviarJogada(tabuleiro);
							}
						}else{
							enviarJogada(tabuleiro);
						}
						
						
					} else {
						System.out.println("entrou no else");
						Posicao posicaoDest = tabuleiro.getPosicoes().get(posicaoDestino);
						int codigoAdversario = jogador2.getCodigo();
						Personagem inimigo = posicaoDest.getOcupante();
						int codigoJogadorAdversario = inimigo.getCodigoJogador();
						if(codigoAdversario == codigoJogadorAdversario) {
							int pontosVida = verificaAtaque(posicaoAtual, posicaoDestino);
							
							if(pontosVida <= 0) {
								jogador2.getTime().remove(inimigo);
								tabuleiro.getPosicoes().get(posicaoDestino).setOcupante(null);
								ator.getTela().mataPersonagem(posicaoDestino);
								int tamanhoLista = jogador2.getTime().size();
								if(tamanhoLista == 0) {
									jogador1.setVencedor(true);
								}
							}
							ator.getTela().notificaAtaque(pontosVida);
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
	}

	public boolean verificaVencedor() {
		// deve existir?
		throw new UnsupportedOperationException();
	}

	public void enviarJogada(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public void criarJogadores(String idUsuario, String idAdversario) {
		this.jogador1 = new Jogador(true, idUsuario, true, 1);
		jogador1.carregarPersonagensAtaque();
		List<Personagem> ataque = jogador1.getTime();
		this.jogador2 = new Jogador(false, idAdversario, false, 2);
		jogador2.carregarPersonagensDefesa();
		List<Personagem> defesa = jogador2.getTime();
		
		tabuleiro.carregarPersonagens(ataque, defesa);
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
	
	private void verificaAndar(int posicaoAtual, int posicaoDestino){
		System.out.println("entrou verificaAndar");
		Personagem personagem = tabuleiro.getPosicoes().get(posicaoAtual).getOcupante();
		int deslocamento = Math.abs(posicaoDestino - posicaoAtual);

		if((deslocamento <= 4) || (deslocamento == 15) || (deslocamento == 30) || (deslocamento == 45) || (deslocamento == 60)) {
				System.out.println("verificou que o deslocamento eh possivel");
				//if(jogador2.getMuro().getPontosVida()!=0){
				//System.out.println("viu que o muro ta vivo");
				// if((posicaoDestino == 10 || 
					//	posicaoDestino == 25 || 
						//posicaoDestino == 40 || 
						//posicaoDestino == 55 || 
						//posicaoDestino == 70 || 
						//posicaoDestino == 85 ||
						//posicaoDestino == 100 ||
						//posicaoDestino == 115 ||
						//posicaoDestino == 130 ||
						//posicaoDestino == 145 ||
						//posicaoDestino == 160)){		/*&& (jogador1.isAtaque()== false)*/
						//System.out.println("viu se a defesa n�o quer atacar o muro");
						//this.ator.getTela().notificaErroAndarMuro();
					if(jogador1.isAtaque()){
					System.out.println("eh ataque");
					if(
							((posicaoDestino > 10) && (posicaoAtual > 10))
						 ||((posicaoDestino > 25 && posicaoDestino <= 29) && (posicaoAtual > 14 && posicaoAtual < 25))
						 ||((posicaoDestino > 40 && posicaoDestino <= 44) && (posicaoAtual > 29 && posicaoAtual < 40))
						 ||((posicaoDestino > 55 && posicaoDestino <= 59) && (posicaoAtual > 44 && posicaoAtual < 55))
						 ||((posicaoDestino > 70 && posicaoDestino <= 74) && (posicaoAtual > 59 && posicaoAtual < 70))
						 ||((posicaoDestino > 85 && posicaoDestino < 89)  && (posicaoAtual > 74 && posicaoAtual < 85))
						 ||((posicaoDestino > 100 && posicaoDestino <= 104) && (posicaoAtual > 89 && posicaoAtual < 90))
						 ||((posicaoDestino > 115 && posicaoDestino <= 119)  && (posicaoAtual > 104 && posicaoAtual < 115))
						 ||((posicaoDestino > 130 && posicaoDestino <= 134) && (posicaoAtual > 119 && posicaoAtual < 130))
						 ||((posicaoDestino > 145 && posicaoDestino <= 149)  && (posicaoAtual > 134 && posicaoAtual < 145))
						 ||((posicaoDestino > 160 && posicaoDestino <= 164) && (posicaoAtual > 149 && posicaoAtual < 160))
							) {
					
						this.ator.getTela().notificaErroPassarMuro();
					
					}else{
						
						System.out.println("deve anda");
						tabuleiro.andar(posicaoAtual, posicaoDestino);
					}
				}else{
					
					if((
							((posicaoAtual > 10 && posicaoAtual <= 14)&& (posicaoDestino > 10))
							|| ((posicaoAtual > 25 && posicaoAtual <= 29)&&(posicaoDestino > 14 && posicaoDestino < 25))
							|| ((posicaoAtual > 40 && posicaoAtual <= 44)&& (posicaoDestino > 29 && posicaoDestino < 40))
							|| ((posicaoAtual > 56 && posicaoAtual <= 59)&& (posicaoDestino > 44 && posicaoDestino < 55))
							|| ((posicaoAtual > 71 && posicaoAtual <= 74)&& (posicaoDestino > 59 && posicaoDestino < 70))
							|| ((posicaoAtual > 86 && posicaoAtual < 89) && (posicaoDestino > 74 && posicaoDestino < 85))
							|| ((posicaoAtual > 101 && posicaoAtual <= 104) && (posicaoDestino > 89 && posicaoDestino < 90))
							|| ((posicaoAtual > 116 && posicaoAtual <= 119) && (posicaoDestino > 104 && posicaoDestino < 115))
							|| ((posicaoAtual > 131 && posicaoAtual <= 134) && (posicaoDestino > 119 && posicaoDestino < 130))
							|| ((posicaoAtual > 146 && posicaoAtual <= 149) && (posicaoDestino > 134 && posicaoDestino < 145))
							|| ((posicaoAtual > 161 && posicaoAtual <= 164) && (posicaoDestino > 149 && posicaoDestino < 160))
							)  
							){
						
						this.ator.getTela().notificaErroPassarMuro();
						
						}else{
							tabuleiro.andar(posicaoAtual, posicaoDestino);
						}
					
				}
			
		}else{
			tela.notificaPoucoAlcance();
		}
				}
//A proxima verificao ve se o ataque ou a desefa tentam ultrapassar do muro				
				
		
	
}