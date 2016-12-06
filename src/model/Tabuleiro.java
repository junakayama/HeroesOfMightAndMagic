package model;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {

	private ArrayList<Posicao> posicoes;
	private Posicao posicaoAtual;
	private Posicao posicaoDestino;
	private Personagem ocupante;
	private Personagem inimigo;
	
	public Tabuleiro() {
		this.posicoes = new ArrayList<Posicao>();
		criarPosicoes();
	}

	
	public boolean isPosicaoOcupada(int posicao) {
		boolean ocupada;
		posicaoDestino=posicoes.get(posicao);
//		ocupada = posicaoDestino.isOcupada();
		ocupada = posicaoDestino.getOcupante()!=null;
		return ocupada;
	}

	public void andar(int posicaoAtual, int posicaoDestino) {
		//n�o ta usando os parametros mandados
		this.posicaoAtual = posicoes.get(posicaoAtual);
		
		this.ocupante = this.posicaoAtual.getOcupante();
		
		this.posicaoDestino = posicoes.get(posicaoDestino);

		this.posicaoDestino.setOcupante(ocupante);
		this.posicaoAtual.setOcupante(null);
		
		this.posicaoDestino = posicoes.get(posicaoDestino);
		ocupante.setAcaoDoTurno(true);
	}

	public void atualizarInformacoes() {
		// TODO - implement Tabuleiro.atualizarInformacoes
		throw new UnsupportedOperationException();
	}

	public void criarPosicoes() {
		for(int i = 0; i < 165; i++) {
			Posicao posicao = new Posicao(i);
			if(i == 89) {
				posicao.setCastelo(true);
			}
			posicoes.add(posicao);
		}
	}

	public void carregarPersonagens(List<Personagem> time1, List<Personagem> time2) {
		for (int i = 0; i < posicoes.size(); i++) {
			Posicao posicao = posicoes.get(i);
			if (i == 77) {
				posicao.setOcupante(time1.get(0));
			}
			if (i == 109) {
				posicao.setOcupante(time1.get(1));
			}
			if (i == 17) {
				posicao.setOcupante(time1.get(2));
			}
			if (i == 137) {
				posicao.setOcupante(time1.get(3));
			}
			if (i == 107) {
				posicao.setOcupante(time1.get(4));
			}
			if (i == 47) {
				posicao.setOcupante(time1.get(5));
			}
			if (i == 49) {
				posicao.setOcupante(time1.get(6));
			}
			if (i == 73) {
				posicao.setOcupante(time2.get(0));
			}
			if (i == 103) {
				posicao.setOcupante(time2.get(1));
			}
			if (i == 56) {
				posicao.setOcupante(time2.get(2));
			}
			if (i == 116) {
				posicao.setOcupante(time2.get(3));
			}
			if (i == 86) {
				posicao.setOcupante(time2.get(4));
			}
			if (i == 26) {
				posicao.setOcupante(time2.get(5));
			}
			if (i == 146) {
				posicao.setOcupante(time2.get(6));
			}
			if(i == 10 || i == 25 || i == 40 || i == 55 || i == 70 || i == 85 ||
					i == 100 || i == 115 || i == 130 || i == 145){
				posicao.setOcupante(time2.get(7));
				posicao.setMuro(true);
			}
		}
	}

	//mudar nome do metodo
	public Personagem jogar(int posicaoAtual, int posicaoDestino) {
		this.posicaoAtual=posicoes.get(posicaoAtual);
		setOcupante(this.posicaoAtual.getOcupante());
		return getOcupante();
	}
	
//	public Personagem buscaOcupante(int posicao) {
//		posicaoAtual=posicoes.get(posicao);
//		setOcupante(posicaoAtual.getOcupante());
//		return getOcupante();
//	}

	public int atacar(int posicaoAtual, int posicaoDestino) {
		this.ocupante = posicoes.get(posicaoAtual).getOcupante();
		Posicao posicaoAt = posicoes.get(posicaoAtual);
		Posicao posicaoDe = posicoes.get(posicaoDestino);
		System.out.println("pegou posicoes");
		Personagem personagemAtaque = posicaoAt.getOcupante();
		Personagem personagemDefesa = posicaoDe.getOcupante();
		System.out.println("pegou personagens");

		int pontosDeAtaque = personagemAtaque.getPontosAtaque();
		int pontosDeVida = personagemDefesa.getPontosVida();
		System.out.println("pegou pontos");

		int resultado = pontosDeVida - pontosDeAtaque;
		
		personagemDefesa.setPontosVida(resultado);
		ocupante.setAcaoDoTurno(true);
		System.out.println("poxa");

		return resultado;
	}


	public boolean verificaCastelo(int posicao) {
		return posicoes.get(posicao).isCastelo();
	}

	public Posicao atribuiInimigoPosicao(int posicaoDestino) {
		inimigo = posicoes.get(posicaoDestino).getOcupante();
		return posicoes.get(posicaoDestino);
		
	}

	public Posicao atribuiPersonagemPosicao(int posicaoDestino) {
		posicoes.get(posicaoDestino).setOcupante(null);
		ocupante.setAcaoDoTurno(true);
		return posicoes.get(posicaoDestino);
	}

	public Personagem getOcupante() {
		return ocupante;
	}

	public void setOcupante(Personagem ocupante) {
		this.ocupante = ocupante;
	}

	public Personagem getInimigo() {
		return inimigo;
	}

	public void setInimigo(Personagem inimigo) {
		this.inimigo = inimigo;
	}
	
	public Posicao verificarPosicao(int posicao){
		return posicoes.get(posicao);
	}
	
	public ArrayList<Posicao> getPosicoes(){
		return posicoes;
	}
	
	public void setPosicoes(ArrayList<Posicao> posicoes) {
		this.posicoes = posicoes;
	}
}