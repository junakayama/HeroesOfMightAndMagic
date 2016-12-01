public class Posicao {

	private boolean ocupada;
	private int linha;
	private int coluna;
	private Personagem ocupante;
	private boolean castelo;

	public int getLinha() {
		return this.linha;
	}

	/**
	 * 
	 * @param linha
	 */
	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return this.coluna;
	}

	/**
	 * 
	 * @param coluna
	 */
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public Personagem getOcupante() {
		return this.ocupante;
	}

	/**
	 * 
	 * @param ocupante
	 */
	public void setOcupante(Personagem ocupante) {
		this.ocupante = ocupante;
	}

	public boolean getOcupada() {
		return this.ocupada;
	}

	/**
	 * 
	 * @param ocupada
	 */
	public void isOcupada(boolean ocupada) {
		// TODO - implement Posicao.isOcupada
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ocupante
	 */
	public void setPersonagem(Personagem ocupante) {
		// TODO - implement Posicao.setPersonagem
		throw new UnsupportedOperationException();
	}

	public void isCastelo() {
		// TODO - implement Posicao.isCastelo
		throw new UnsupportedOperationException();
	}

	public Personagem getPersonagem() {
		// TODO - implement Posicao.getPersonagem
		throw new UnsupportedOperationException();
	}

}