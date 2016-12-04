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
		super();
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
		this.posicaoDestino.setOcupante(ocupante);
		this.posicaoAtual.setOcupante(null);
		ocupante.setAcaoDoTurno(true);
	}

	public void atualizarInformacoes() {
		// TODO - implement Tabuleiro.atualizarInformacoes
		throw new UnsupportedOperationException();
	}

	public void criarPosicoes() {
		for(int i=0;i<11;i++){
			for (int j = 0; j < 15; j++) {
				Posicao posicao = new Posicao(i, j, null, false);
				if(posicao.getLinha()==14 && posicao.getColuna()==6){
					posicao.setCastelo(true);
				}
				posicoes.add(posicao);
			}
		}
	}

	public void carregarPersonagens(List<Personagem> time1, List<Personagem> time2) {
		for (int i = 0; i < posicoes.size(); i++) {
			Posicao posicao = posicoes.get(i);
			if (posicao.getLinha() == 1 && posicao.getColuna() == 1) {
				posicao.setOcupante(time1.get(0));
			}
			if (posicao.getLinha() == 1 && posicao.getColuna() == 1) {
				posicao.setOcupante(time1.get(1));
			}
			if (posicao.getLinha() == 2 && posicao.getColuna() == 2) {
				posicao.setOcupante(time1.get(2));
			}
			if (posicao.getLinha() == 3 && posicao.getColuna() == 1) {
				posicao.setOcupante(time1.get(3));
			}
			if (posicao.getLinha() == 4 && posicao.getColuna() == 1) {
				posicao.setOcupante(time1.get(4));
			}
			if (posicao.getLinha() == 5 && posicao.getColuna() == 1) {
				posicao.setOcupante(time1.get(5));
			}
			if (posicao.getLinha() == 6 && posicao.getColuna() == 2) {
				posicao.setOcupante(time1.get(6));
			}
			if (posicao.getLinha() == 1 && posicao.getColuna() == 12) {
				posicao.setOcupante(time2.get(0));
			}
			if (posicao.getLinha() == 2 && posicao.getColuna() == 11) {
				posicao.setOcupante(time2.get(1));
			}
			if (posicao.getLinha() == 3 && posicao.getColuna() == 12) {
				posicao.setOcupante(time2.get(2));
			}
			if (posicao.getLinha() == 4 && posicao.getColuna() == 11) {
				posicao.setOcupante(time2.get(3));
			}
			if (posicao.getLinha() == 5 && posicao.getColuna() == 12) {
				posicao.setOcupante(time2.get(4));
			}
			if (posicao.getLinha() == 6 && posicao.getColuna() == 11) {
				posicao.setOcupante(time2.get(5));
			}
			if (posicao.getLinha() == 7 && posicao.getColuna() == 12) {
				posicao.setOcupante(time2.get(6));
			}
			
			if(posicao.getColuna()==9){
				posicoes.get(9).setOcupante(time2.get(7));
				posicoes.get(24).setOcupante(time2.get(7));
				posicoes.get(39).setOcupante(time2.get(7));
				posicoes.get(54).setOcupante(time2.get(7));
				posicoes.get(69).setOcupante(time2.get(7));
				posicoes.get(84).setOcupante(time2.get(7));
				posicoes.get(99).setOcupante(time2.get(7));
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
		
		Posicao posicaoAt = posicoes.get(posicaoAtual);
		Posicao posicaoDe = posicoes.get(posicaoDestino);
		
		Personagem personagemAtaque = posicaoAt.getOcupante();
		Personagem personagemDefesa = posicaoDe.getOcupante();
		
		int pontosDeAtaque = personagemAtaque.getPontosAtaque();
		int pontosDeVida = personagemDefesa.getPontosVida();
		
		int resultado = pontosDeVida - pontosDeAtaque;
		
		personagemDefesa.setPontosVida(resultado);
		ocupante.setAcaoDoTurno(true);
		
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