public class Personagem {

	private Integer pontosVida;
	private Integer pontosAtaque;
	private Boolean acaoDoTurno;
	private Boolean longoAlcance;
	private Boolean selecionado;
	private String nome;
	private Posicao posicao;
	private int codigoJogador;

	/**
	 * 
	 * @param acaoDoTurno
	 */
	public void setAcaoDoTurno(boolean acaoDoTurno) {
		// TODO - implement Personagem.setAcaoDoTurno
		throw new UnsupportedOperationException();
	}

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

	public void setSelecionado() {
		// TODO - implement Personagem.setSelecionado
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

	public int getPontosAtaque() {
		// TODO - implement Personagem.getPontosAtaque
		throw new UnsupportedOperationException();
	}

	public void getPontosVida() {
		// TODO - implement Personagem.getPontosVida
		throw new UnsupportedOperationException();
	}

}