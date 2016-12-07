package model;

import java.util.ArrayList;
import java.util.List;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Tabuleiro  implements Jogada {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Posicao> posicoes;
	
	public Tabuleiro() {
		this.posicoes = new ArrayList<Posicao>();
		criarPosicoes();
	}

	
	public boolean isPosicaoOcupada(int posicao) {
		boolean ocupada;
		Posicao posicaoDestino = posicoes.get(posicao);
		ocupada = posicaoDestino.getOcupante()!=null;
		return ocupada;
	}

	public void andar(int posicaoAtual, int posicaoDestino) {
		Posicao posicaoAt = posicoes.get(posicaoAtual);
		Personagem ocupante = posicaoAt.getOcupante();
		Posicao posicaoDest = posicoes.get(posicaoDestino);
		posicaoDest.setOcupante(ocupante);
		posicaoAt.setOcupante(null);
		posicaoDest = posicoes.get(posicaoDestino);
		
		ocupante.setAcaoDoTurno(true);
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
	
	public int atacar(int posicaoAtual, int posicaoDestino) {
		Personagem ocupante = posicoes.get(posicaoAtual).getOcupante();
		Posicao posicaoAt = posicoes.get(posicaoAtual);
		Posicao posicaoDest = posicoes.get(posicaoDestino);
		Personagem personagemAtaque = posicaoAt.getOcupante();
		Personagem personagemDefesa = posicaoDest.getOcupante();

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