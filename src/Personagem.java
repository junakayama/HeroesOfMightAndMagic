public class Personagem {

	private int pontosVida;
	private int pontosAtaque;
	private boolean acaoDoTurno;
	private boolean longoAlcance;
	private boolean selecionado;
	private String nome;
	private Posicao posicao;
	private int codigoJogador;

	/**
	 * 
	 * @param pontosAtaque
	 */
	public int recebeDano(int pontosAtaque) {
		// TODO - implement Personagem.recebeDano
		throw new UnsupportedOperationException();
	}

	public boolean verificaPontosDeVida() {
		// TODO - implement Personagem.verificaPontosDeVida
		throw new UnsupportedOperationException();
	}

	public void selecionarPersonagem() {
		// TODO - implement Personagem.selecionarPersonagem
		throw new UnsupportedOperationException();
	}

	public int getCodigoJogador() {
		return this.codigoJogador;
	}

	/**
	 * 
	 * @param codigoJogador
	 */
	public void setCodigoJogador(int codigoJogador) {
		this.codigoJogador = codigoJogador;
	}

	public void setPontosVida(int pontosVida) {
		this.pontosVida = pontosVida;
	}
	
	public int getPontosVida() {
		return pontosVida;
	}
	
	public int getPontosAtaque() {
		return pontosAtaque;
	}

	public void setPontosAtaque(int pontosAtaque) {
		this.pontosAtaque = pontosAtaque;
	}

	public boolean getAcaoDoTurno() {
		return acaoDoTurno;
	}

	public void setAcaoDoTurno(boolean acaoDoTurno) {
		this.acaoDoTurno = acaoDoTurno;
	}

	public boolean isLongoAlcance() {
		return longoAlcance;
	}

	public void setLongoAlcance(boolean longoAlcance) {
		this.longoAlcance = longoAlcance;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

}