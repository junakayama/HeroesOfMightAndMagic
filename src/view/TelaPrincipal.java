package view;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame {

	protected final AtorJogador ator;
	protected JPanel jContentPane = null;

	protected LabelImg[] labels;
	protected Integer atual;
	protected Integer destino;

	protected JMenuItem btnIniciar = null;
	protected JMenuItem btnConectar = null;
	protected JMenuItem btnDesconectar = null;
}
		