package view;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame implements ActionListener {

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//		Atributos 		//


	protected JPanel jContentPane = null;

	protected LabelImg[] labels;
	protected Integer atual;
	protected Integer destino;

	
	protected JButton btnIniciar;
	protected JButton conectar;
	protected JButton btnDesconectar;
	protected JButton btnPassarTurno;
	
	protected JLabel user;
	private AtorJogador ator;

//		Construtor		//
	public TelaPrincipal(final AtorJogador ator) {
		this.ator = ator;
		this.setSize(1000, 700);
		this.user = new JLabel();
		this.setContentPane(getJContentPane());
		this.setTitle("Heroes Of Might And Magic - Game Of Thrones");
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		poeBotoes();
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			
		    
			labels = new LabelImg[165];
			
			int contador = 0;
			int tamanhoColuna = 20;
			for(int i = 0; i < 11; i++){
				int tamanhoLinha = 20;
				for(int j = 0; j < 15; j++){
					LabelImg label = new LabelImg(contador);
					label.setImagem("campo.png");
					label.setBounds(new Rectangle(tamanhoLinha, tamanhoColuna, 50, 50));
					if(contador == 10 || contador == 25 || contador == 40 || contador == 55 || contador == 70 || contador == 85 ||
							contador == 100 || contador == 115 || contador == 130 || contador == 145 || contador == 160){
						label.setImagem2("muro.png");
					}
					if(contador == 26 || contador == 146){
						label.setImagem2("guarda.png");
					}
					if(contador == 89){
						label.setImagem("castle.png");
					}
					label.setIcon(new ImageIcon(getClass().getResource(label.retornaImagem())));
					labels[contador] = label;
					contador++;
					tamanhoLinha+=51;
					jContentPane.add(label, null);
				}
				tamanhoColuna+=51;
			}
			labels[109].setImagem2("dani.png");
			labels[109].setIcon(new ImageIcon(getClass().getResource(labels[109].retornaImagem())));
			labels[49].setImagem2("tyrion.png");
			labels[49].setIcon(new ImageIcon(getClass().getResource(labels[49].retornaImagem())));
			labels[47].setImagem2("misandei.png");
			labels[47].setIcon(new ImageIcon(getClass().getResource(labels[47].retornaImagem())));
			labels[107].setImagem2("jorah.png");
			labels[107].setIcon(new ImageIcon(getClass().getResource(labels[107].retornaImagem())));
			labels[17].setImagem2("barristan.png");
			labels[17].setIcon(new ImageIcon(getClass().getResource(labels[17].retornaImagem())));
			labels[77].setImagem2("dragon.png");
			labels[77].setIcon(new ImageIcon(getClass().getResource(labels[77].retornaImagem())));
			labels[137].setImagem2("verme.png");
			labels[137].setIcon(new ImageIcon(getClass().getResource(labels[137].retornaImagem())));
			
			labels[56].setImagem2("gregor.png");
			labels[56].setIcon(new ImageIcon(getClass().getResource(labels[56].retornaImagem())));
			labels[86].setImagem2("jaime.jpg");
			labels[86].setIcon(new ImageIcon(getClass().getResource(labels[86].retornaImagem())));
			labels[116].setImagem2("hound.png");
			labels[116].setIcon(new ImageIcon(getClass().getResource(labels[116].retornaImagem())));
			labels[103].setImagem2("cercei.png");
			labels[103].setIcon(new ImageIcon(getClass().getResource(labels[103].retornaImagem())));
			labels[73].setImagem2("lion.png");
			labels[73].setIcon(new ImageIcon(getClass().getResource(labels[73].retornaImagem())));

			labels[0].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(0);
				}
			});
			labels[1].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(1);
				}
			});
			labels[2].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(2);
				}
			});
			labels[3].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(3);
				}
			});
			labels[4].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(4);				}
			});
			labels[5].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(5);				}
			});
			labels[6].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(6);				}
			});
			labels[7].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(7);				}
			});
			labels[8].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(8);				}
			});
			labels[9].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(9);				}
			});
			labels[10].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(10);				}
			});
			labels[11].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(11);				}
			});
			labels[12].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(12);				}
			});
			labels[13].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(13);				}
			});
			labels[14].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(14);				}
			});
			labels[15].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(15);				}
			});
			labels[16].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(16);				}
			});
			labels[17].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(17);				}
			});
			labels[18].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(18);				}
			});
			labels[19].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(19);				}
			});
			labels[20].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(20);				}
			});
			labels[21].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(21);				}
			});
			labels[22].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(22);				}
			});
			labels[23].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(23);				}
			});
			labels[24].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(24);				}
			});
			labels[25].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(25);				}
			});
			labels[26].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(26);				}
			});
			labels[27].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(27);				}
			});
			labels[28].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(28);				}
			});
			labels[29].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(29);				}
			});
			labels[30].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(30);				}
			});
			labels[31].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(31);				}
			});
			labels[32].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(32);				}
			});
			labels[33].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(33);				}
			});
			labels[34].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(34);				}
			});
			labels[35].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(35);				}
			});
			labels[36].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(36);				}
			});
			labels[37].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(37);				}
			});
			labels[38].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(38);				}
			});
			labels[39].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(39);				}
			});
			labels[40].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(40);				}
			});
			labels[41].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(41);				}
			});
			labels[42].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(42);				}
			});
			labels[43].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(43);				}
			});
			labels[44].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(44);				}
			});
			labels[45].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(45);				}
			});
			labels[46].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(46);				}
			});
			labels[47].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(47);				}
			});
			labels[48].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(48);				}
			});
			labels[49].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(49);				}
			});
			labels[50].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(50);				}
			});
			labels[51].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(51);				}
			});
			labels[52].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(52);				}
			});
			labels[53].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(53);				}
			});
			labels[54].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(54);				}
			});
			labels[55].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(55);				}
			});
			labels[56].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(56);				}
			});
			labels[57].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(57);				}
			});
			labels[58].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(58);				}
			});
			labels[59].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(59);				}
			});
			labels[60].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(60);				}
			});
			labels[61].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(61);				}
			});
			labels[62].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(62);				}
			});
			labels[63].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(63);				}
			});
			labels[64].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(64);				}
			});
			labels[65].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(65);				}
			});
			labels[66].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(66);				}
			});
			labels[67].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(67);				}
			});
			labels[68].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(68);				}
			});
			labels[69].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(69);				}
			});
			labels[70].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(70);				}
			});
			labels[71].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(71);				}
			});
			labels[72].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(72);				}
			});
			labels[73].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(73);				}
			});
			labels[74].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(74);				}
			});
			labels[75].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(75);				}
			});
			labels[76].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(76);				}
			});
			labels[77].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(77);				}
			});
			labels[78].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(78);				}
			});
			labels[79].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(79);				}
			});
			labels[80].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(80);				}
			});
			labels[81].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(81);				}
			});
			labels[82].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(82);				}
			});
			labels[83].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(83);				}
			});
			labels[84].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(84);				}
			});
			labels[85].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(85);				}
			});
			labels[86].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(86);				}
			});
			labels[87].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(87);				}
			});
			labels[88].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(88);				}
			});
			labels[89].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(89);				}
			});
			labels[90].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(90);				}
			});
			labels[91].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(91);				}
			});
			labels[92].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(92);				}
			});
			labels[93].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(93);				}
			});
			labels[94].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(94);				}
			});
			labels[95].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(95);				}
			});
			labels[96].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(96);				}
			});
			labels[97].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(97);				}
			});
			labels[98].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(98);				}
			});
			labels[99].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(99);				}
			});
			labels[100].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(100);				}
			});
			labels[101].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(101);				}
			});
			labels[102].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(102);				}
			});
			labels[103].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(103);				}
			});
			labels[104].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(104);				}
			});
			labels[105].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(105);				}
			});
			labels[106].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(106);				}
			});
			labels[107].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(107);				}
			});
			labels[108].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(108);				}
			});
			labels[109].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(109);				}
			});
			labels[110].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(110);				}
			});
			labels[111].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(111);				}
			});
			labels[112].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(112);				}
			});
			labels[113].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(113);				}
			});
			labels[114].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(114);				}
			});
			labels[115].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(115);				}
			});
			labels[116].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(116);				}
			});
			labels[117].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(117);				}
			});
			labels[118].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(118);				}
			});
			labels[119].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(119);				}
			});
			labels[120].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(120);				}
			});
			labels[121].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(121);				}
			});
			labels[122].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(122);				}
			});
			labels[123].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(123);				}
			});
			labels[124].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(124);				}
			});
			labels[125].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(125);				}
			});
			labels[126].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(126);				}
			});
			labels[127].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(127);				}
			});
			labels[128].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(128);				}
			});
			labels[129].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(129);				}
			});
			labels[130].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(130);				}
			});
			labels[131].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(131);				}
			});
			labels[132].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(132);				}
			});
			labels[133].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(133);				}
			});
			labels[134].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(134);				}
			});
			labels[135].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(135);				}
			});
			labels[136].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(136);				}
			});
			labels[137].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(137);				}
			});
			labels[138].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(138);				}
			});
			labels[139].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(139);				}
			});
			labels[140].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(140);				}
			});
			labels[141].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(141);				}
			});
			labels[142].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(142);				}
			});
			labels[143].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(143);				}
			});
			labels[144].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(144);				}
			});
			labels[145].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(145);				}
			});
			labels[146].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(146);				}
			});
			labels[147].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(147);				}
			});
			labels[148].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(148);				}
			});
			labels[149].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(149);				}
			});
			labels[150].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(150);				}
			});
			labels[151].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(151);				}
			});
			labels[152].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(152);				}
			});
			labels[153].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(153);				}
			});
			labels[154].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(154);				}
			});
			labels[155].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(155);				}
			});
			labels[156].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(156);				}
			});
			labels[157].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(157);				}
			});
			labels[158].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(158);				}
			});
			labels[159].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(159);				}
			});
			labels[160].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(160);				}
			});
			labels[161].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(161);				}
			});
			labels[162].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(162);				}
			});
			labels[163].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(163);				}
			});
			labels[164].addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					clickPosicao(164);				}
			});
			
		

		}
		return jContentPane;
	}

	public void poeBotoes(){
		
		btnIniciar = new JButton("Iniciar Partida");
		btnIniciar.setBounds(30, 590 , 150, 30 );
		
		conectar = new JButton ("Conectar");
		conectar.setBounds(180, 590, 150, 30);
		
		btnDesconectar = new JButton ("Desconectar");
		btnDesconectar.setBounds(330, 590, 150,30);
		
		btnPassarTurno = new JButton ("Passar Turno");
		btnPassarTurno.setBounds(480, 590, 150, 30);
		
	    getContentPane().add(btnIniciar);
		
		getContentPane().add(btnDesconectar);

	    getContentPane().add(conectar);
	    
	    getContentPane().add(btnPassarTurno);
	    
	    getConectar();
	    getIniciar();
	    getDesconectar();
	    getPassarTurno();
	    
	    btnDesconectar.setEnabled(false);
	    btnIniciar.setEnabled(false);
	    btnPassarTurno.setEnabled(false);
	    
	}
	
	
	public void btConectar(){
		btnIniciar.setEnabled(true);
		conectar.setEnabled(false);
		conectar.setVisible(false);
		btnIniciar.setBounds(30, 590 , 150, 30);
		btnDesconectar.setBounds(180, 590, 150, 30);
		btnPassarTurno.setBounds(330, 590, 150,30);
		
	}
	
	public void btIniciarPartida(){
		btnIniciar.setEnabled(false);
		btnIniciar.setVisible(false);
		btnPassarTurno.setEnabled(true);
		btnDesconectar.setBounds(180, 590, 150, 30);
		btnPassarTurno.setBounds(30, 590 , 150, 30);
		
	}
	
	public void clickPosicao(int posicao){
		if(this.atual != null && this.atual != posicao && labels[this.atual].getImagem2() != null){
			try {
				boolean ocupada = (ator.getPartida().getTabuleiro().getPosicoes().get(posicao).getOcupante() != null);
				this.ator.jogar(this.atual, posicao);
				this.destino = posicao;
				this.atualizaInterface(this.atual, this.destino, ocupada);
				this.atual = null;
				this.destino = null;
				System.out.println("posicao: "+posicao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				this.atual = null;
				this.destino = null;
			}
			
		} else {
			this.atual = posicao;
			System.out.println("primeiro click: " + posicao);
		}
	}
	
	public JButton getConectar(){
		conectar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					
					ator.conectar();
					btnIniciar.setEnabled(true);
					btnDesconectar.setEnabled(true);
					conectar.setEnabled(false);
					
				} catch (Exception ex) {
				
					ex.printStackTrace();
				}
			}
		});
		
		return conectar;
		
	}
	
	
	public JButton getIniciar(){
		btnIniciar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					
					ator.iniciarPartida();
					btIniciarPartida();
					
					
				} catch (Exception ex) {
				
					ex.printStackTrace();
				}
			}
		});
		
		return btnIniciar;
		
	}
	
	public JButton getPassarTurno(){
		btnPassarTurno.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					
					ator.passarTurnoJogadorAtual();
					
					
				} catch (Exception ex) {
				
					ex.printStackTrace();
				}
			}
		});
		
		return btnPassarTurno;
		
	}

	public JButton getDesconectar(){
		btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				try {
					
					ator.desconectar();
					
					
					
				} catch (Exception ex) {
				
					ex.printStackTrace();
				}
			}
		});
		
		return btnDesconectar;
		
	}

	private void atualizaInterface(int saida, int entrada, boolean ocupada) {
		if(!ocupada){
			labels[entrada].setImagem2(labels[saida].getImagem2());
			labels[entrada].setIcon(new ImageIcon(getClass().getResource(labels[entrada].getImagem2())));
			labels[saida].setImagem2(null);
			labels[saida].setIcon(new ImageIcon(getClass().getResource(labels[saida].retornaImagem())));
		}
	}

	public void actionPerformed(ActionEvent e) {

		String ac = e.getActionCommand();
		if (ac == btnIniciar.toString()){
			ator.iniciarPartida();
		}else if(ac == conectar.toString()){
			ator.conectar();
		}else if(ac == btnDesconectar.toString()){
			ator.desconectar();
		}else if(ac == btnPassarTurno.toString()){
			ator.passarTurnoJogadorAtual();
		}	
	}
	
	public void mataPersonagem(int posicao) {
		labels[posicao].setImagem2(null);
		labels[posicao].setIcon(new ImageIcon(getClass().getResource(labels[posicao].getImagem())));
		JOptionPane.showMessageDialog(null, "Morreu" );
	}
	
	public void notificaAtaque(int pontosDeVida) {
		JOptionPane.showMessageDialog(null, "Atacou! Personagem adversÃ¡rio possui "+pontosDeVida+" pontos de vida" );
	}
		
	public void notificaAndamento() {
		JOptionPane.showMessageDialog(null, "Jï¿½ existe uma partida em andamento!");
		
	}

	public void notificaIniciada() {
		JOptionPane.showMessageDialog(null, "Sua partida foi iniciada!");
		
	}
	
	public void notificaVencedor() {
		JOptionPane.showMessageDialog(null, "Vocï¿½ venceu, parabï¿½ns!");
		
	}
	
	public void notificaErroTurno() {
		JOptionPane.showMessageDialog(null , "Nï¿½o estï¿½ na hora de jogar ainda, aguarda o seu turno");
		
	}

	public void notificaErroInstancia() {
		JOptionPane.showMessageDialog(null , "Ops!Parece que vocï¿½ selecionou errado...");
		
	}
	
	public void notificaDesconectado() {
		JOptionPane.showMessageDialog(null , "Desconexï¿½o realizada com sucesso!");
		
	}

	public void notificaErroDesconectado() {
		JOptionPane.showMessageDialog(null , "Desconexï¿½o falhada! Tente novamente.");
		
	}

	public void notificaErroAndarMuro() {
		JOptionPane.showMessageDialog(null , "Ops! Você não pode ficar em cima do muro");
		
	}

	public void notificaErroPassarMuro() {
		JOptionPane.showMessageDialog(null , "Ops! Você não pode atravessar o muro");
		
	}
}
