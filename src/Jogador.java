public class Jogador {

	private boolean ataque;
	private Personagem[] time;
	private String nickName;
	private boolean turno;
	private boolean vencedor;
	private int codigo;
	private boolean passarTurno;

	public void jogar() {
		// TODO - implement Jogador.jogar
		throw new UnsupportedOperationException();
	}

	public void procederJogada() {
		// TODO - implement Jogador.procederJogada
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

	public void selecionarPersonagem() {
		// TODO - implement Jogador.selecionarPersonagem
		throw new UnsupportedOperationException();
	}

	public void selecionarPersonagemAdversario() {
		// TODO - implement Jogador.selecionarPersonagemAdversario
		throw new UnsupportedOperationException();
	}

	public void carregarPersonagens() {
		// TODO - implement Jogador.carregarPersonagens
		throw new UnsupportedOperationException();
	}

	public Jogador() {
		// TODO - implement Jogador.Jogador
		throw new UnsupportedOperationException();
	}

	public boolean isTurno() {
		return this.turno;
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
		// TODO - implement Jogador.carregarPersonagensAtaque
		throw new UnsupportedOperationException();
	}

	public void carregarPersonagensDefesa() {
		// TODO - implement Jogador.carregarPersonagensDefesa
		throw new UnsupportedOperationException();
	}

}