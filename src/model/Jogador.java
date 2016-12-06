package model;

import java.util.ArrayList;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Jogador  implements Jogada {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean ataque;
	private ArrayList<Personagem> time;
	private String nickName;
	private boolean turno;
	private boolean vencedor;
	private int codigo;
	private boolean passarTurno;
	private Muro muro;
	
	public Jogador(boolean ataque, String nome, boolean turno, int codigo) {
		this.ataque = ataque;
		this.nickName = nome;
		this.turno = turno;
		this.codigo = codigo;

	}

	public void jogar() {
		// TODO - implement Jogador.jogar
		throw new UnsupportedOperationException();
	}

	public void receberJogada() {
		// TODO - implement Jogador.receberJogada
		throw new UnsupportedOperationException();
	}

	public boolean verificaVencedor() {
		// TODO - implement Jogador.verificaVencedor
		throw new UnsupportedOperationException();
	}

	public boolean isTurno() {
		return this.turno;
	}
	
	public void setTurno(boolean turno) {
		this.turno = turno;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public boolean isAtaque() {
		return this.ataque;
	}

	/**
	 * 
	 * @param vencedor
	 */
	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}

	public boolean isPassarTurno() {
		return this.passarTurno;
	}

	public boolean isVencedor() {
		return this.vencedor;
	}

	public void carregarPersonagensAtaque() {
		this.time = new ArrayList<Personagem>();

		Personagem dragao = new Personagem("dragon.png", this.codigo, 20, 10, false, true);
		this.time.add(0, dragao);

		Personagem daenerysTargaryen = new Personagem("dani.png", this.codigo, 18, 9, false, false);
		this.time.add(1, daenerysTargaryen);

		Personagem sorBarristan = new Personagem("barristan.png", this.codigo, 16, 8, false, false);
		this.time.add(2, sorBarristan);

		Personagem vermeCinzento = new Personagem("verme.png", this.codigo, 14, 7, false, false);
		this.time.add(3, vermeCinzento);

		Personagem jorahMormont = new Personagem("jorah.png", this.codigo, 12, 6, false, false);
		this.time.add(4, jorahMormont);

		Personagem missandei = new Personagem("misandei.png", this.codigo, 10, 5, false, false);
		this.time.add(5, missandei);

		Personagem tyrionLannister = new Personagem("tyrion.png", this.codigo, 8, 4, false, false);
		this.time.add(6, tyrionLannister);

	}

	public void carregarPersonagensDefesa() {

		this.time = new ArrayList<Personagem>();

		Personagem leao = new Personagem("lion.png", this.codigo, 20, 10, false, true);
		this.time.add(0, leao);

		Personagem cerceiLannister = new Personagem("cercei.png", this.codigo, 18, 9, false, false);
		this.time.add(1, cerceiLannister);

		Personagem montanha = new Personagem("gregor.png", this.codigo, 16, 8, false, false);
		this.time.add(2, montanha);

		Personagem cao = new Personagem("hound.png", this.codigo, 14, 7, false, false);
		this.time.add(3, cao);

		Personagem jaimeLannister = new Personagem("jaime.jpg", this.codigo, 12, 6, false, false);
		this.time.add(4, jaimeLannister);

		Personagem guarda1 = new Personagem("guarda.png", this.codigo, 10, 5, false, false);
		this.time.add(5, guarda1);

		Personagem guarda2 = new Personagem("guarda.png", this.codigo, 8, 4, false, false);
		this.time.add(6, guarda2);

		this.muro = new Muro("muro.png", this.codigo, 50);
		this.time.add(7, muro);
	}

	public ArrayList<Personagem> getTime() {
		return time;
	}

	public void setTime(ArrayList<Personagem> time) {
		this.time = time;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Muro getMuro(){
		return this.muro;
	}
}