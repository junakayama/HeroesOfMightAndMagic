package view;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame {

	
//		Atributos 		//
	protected final AtorJogador ator;
	protected JPanel jContentPane = null;

	protected LabelImg[] labels;
	protected Integer atual;
	protected Integer destino;

	protected JMenuItem btnIniciar = null;
	protected JMenuItem btnConectar = null;
	protected JMenuItem btnDesconectar = null;
	
	protected JLabel user;

//		Construtor		//
	public TelaPrincipal(final AtorJogador ator) {
		this.ator = ator;
		this.setSize(1100, 1000);
		this.user = new JLabel();
		this.setContentPane(getJContentPane());
		this.setTitle("Heroes Of Might And Magic - Game Of Thrones");
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
// 		La vem bomba	//
}
		