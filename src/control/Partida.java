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
	private TelaPrincipal tela;
	private AtorJogador ator;

	public Partida(AtorJogador ator) {
		numRodadas = 15;
		tabuleiro = new Tabuleiro();
		criarJogadores();
		this.ator = ator;
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
		tela.notificaAndamento();
	}

	public void notificaPartidaIniciada() {
		tela.notificaIniciada();
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
						//tabuleiro.andar(posicaoAtual, posicaoDestino);
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

	public void criarJogadores() {
		String nickname = jogador1.getNickName();
		String nicknameAdversario = jogador2.getNickName();
		this.jogador1 = new Jogador(true, nickname, true, 1);
		jogador1.carregarPersonagensAtaque();
		List<Personagem> ataque = jogador1.getTime();
		this.jogador2 = new Jogador(false, nicknameAdversario, false, 2);
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
	
	private void verificaAndar(int posicaoAtual, int posicaoDestino) throws Exception {
		Personagem personagem = tabuleiro.getPosicoes().get(posicaoAtual).getOcupante();
		int deslocamento = Math.abs(posicaoDestino - posicaoAtual);

		if(deslocamento <= 4 || deslocamento == 15) {
	
			if(jogador2.getMuro().getPontosVida()!=0){
				if((posicaoDestino == 10 || posicaoDestino == 25 || posicaoDestino == 40 || posicaoDestino == 55 || posicaoDestino == 70 || posicaoDestino == 85 ||
				posicaoDestino == 100 || posicaoDestino == 115 || posicaoDestino == 130 || posicaoDestino == 145 || posicaoDestino == 160)&& jogador1.isAtaque()== false){
		
					tela.notificaErroAndarMuro();
				}
//A proxima verifica��o ve se o ataque ou a desefa tentam ultrapassar do muro				
				if(jogador1.isAtaque()){
					
					if(((posicaoDestino > 10) || (posicaoDestino > 25 & posicaoDestino <= 29) || (posicaoDestino > 40 & posicaoDestino <= 44)|| (posicaoDestino > 56 & posicaoDestino <= 59) || (posicaoDestino > 71 & posicaoDestino <= 74) || (posicaoDestino > 86 & posicaoDestino < 89) || (posicaoDestino > 101 & posicaoDestino <= 104) || (posicaoDestino > 116 & posicaoDestino <= 119) || (posicaoDestino > 131 & posicaoDestino <= 134) || (posicaoDestino > 146 & posicaoDestino <= 149) || (posicaoDestino > 161 & posicaoDestino <= 164)) & ((posicaoAtual > 10) || (posicaoAtual > 14 & posicaoAtual < 25) || (posicaoAtual > 29 & posicaoAtual < 40) || (posicaoAtual > 44 & posicaoAtual < 55 ) || (posicaoAtual > 59 & posicaoAtual < 70) || (posicaoAtual > 74 & posicaoAtual < 85) || (posicaoAtual > 89 & posicaoAtual < 90 ) || (posicaoAtual > 104 & posicaoAtual < 115) || (posicaoAtual > 119 & posicaoAtual < 130) || (posicaoAtual > 134 & posicaoAtual < 145) || (posicaoAtual > 149 & posicaoAtual < 160) ) ){
					
					tela.notificaErroPassarMuro();
					
					}else{
						tabuleiro.andar(posicaoAtual, posicaoDestino);
					}
				}else{
					
					if(((posicaoAtual > 10) || (posicaoAtual > 25 & posicaoAtual <= 29) || (posicaoAtual > 40 & posicaoAtual <= 44)|| (posicaoAtual > 56 & posicaoAtual <= 59) || (posicaoAtual > 71 & posicaoAtual <= 74) || (posicaoAtual > 86 & posicaoAtual < 89) || (posicaoAtual > 101 & posicaoAtual <= 104) || (posicaoAtual > 116 & posicaoAtual <= 119) || (posicaoAtual > 131 & posicaoAtual <= 134) || (posicaoAtual > 146 & posicaoAtual <= 149) || (posicaoAtual > 161 & posicaoAtual <= 164)) & ((posicaoDestino > 10) || (posicaoDestino > 14 & posicaoDestino < 25) || (posicaoDestino > 29 & posicaoDestino < 40) || (posicaoDestino > 44 & posicaoDestino < 55 ) || (posicaoDestino > 59 & posicaoDestino < 70) || (posicaoDestino > 74 & posicaoDestino < 85) || (posicaoDestino > 89 & posicaoDestino < 90 ) || (posicaoDestino > 104 & posicaoDestino < 115) || (posicaoDestino > 119 & posicaoDestino < 130) || (posicaoDestino > 134 & posicaoDestino < 145) || (posicaoDestino > 149 & posicaoDestino < 160) ) ){
						
						tela.notificaErroPassarMuro();
						
						}else{
							tabuleiro.andar(posicaoAtual, posicaoDestino);
						}
					
				}
			}
				
		
	
			tabuleiro.andar(posicaoAtual, posicaoDestino);
		}
		throw new Exception("Nao pode andar, personagem esta muito longe");
	}
}