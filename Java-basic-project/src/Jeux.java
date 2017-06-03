import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

class Joueur {
	// Class Joueur qui change le numero a chaque fois qu'on clique sur le
	// bouton finir, ce qui change le Joueur
	public static int numero = 1;
	public static int score[];

	Joueur(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
}

class Quitter implements ActionListener {

	public void actionPerformed(ActionEvent event) {
		// frame.setVisible(false);
		System.exit(0);
	}
}

class Goban extends JPanel implements MouseListener, ActionListener {
	JFrame fenetre;
	static int[] plateaux = new int[300]; // Le plateau qui enregiste les coups
											// en x pour les annuler apres
	static int[] plateauy = new int[300]; // meme chose en y
	static int[] plateaux2 = new int[300];// Ne sert a rien
	static int[] plateauy2 = new int[300];// Ne sert a rien

	static int[] desannulerx = new int[300]; // Plateau qui enregiste les coups
												// qu'on a annulé si on veut
												// desannuler en x
	static int[] desannulery = new int[300]; // meme chose en

	int x;
	int y;
	int numerobouton; // En fonction du bouton, on a un id pour chaque bouton.
	int numero = 0; // La variable qui s'increment chaque coup dans le plateau
					// qui enregistre les coups pour annuler
	int numero2 = 0;// Ne sert a rien
	int numerodes = 0; // La variable qui s'increment chaque coup dans le
						// tableau desanuller qui enregistre les coups qui ont
						// été annulé
	static int x2;
	static int y2;
	// JTextField taille;

	int[][] plateau = new int[9][9]; // Le tableau principale

	Graphics g;
	JPanel panel;
	JTextField tailles;
	int chiffre;
	int i = 1;
	int j = 299;

	public static int taille = Text.chiffreSize;
	Text text = new Text(tailles, fenetre);

	Goban(JTextField tailles, JFrame fenetre, int numerobouton) {
		this.numerobouton = numerobouton;
		this.tailles = tailles;
		this.fenetre = fenetre;

	}

	public int getX(int x) {
		return x;
	}

	public void paint(Graphics g, int x, int y) {

		g.drawOval(x * 20 - 5, y * 20 - 5, 10, 10);
	}

	public void supprimer(int x2, int y2, int[][] plateau, int taille) {
		// Evite le suicide, si une case a le chiffre 1 , on regarde si les
		// cases autour ont le chiffre 2. SI oui, on remet la case a 0
		// Le probleme ici est sur les extremités, il y'aura une erreur car on
		// regardera a des endroits qui existe pas

		// if (plateau[x2][y2] == 1) {
		// if (plateau[x2 - 1][y2] == 2 && plateau[x2 + 1][y2] == 2 &&
		// plateau[x2][y2 + 1] == 2
		// && plateau[x2][y2 - 1] == 2) {
		// plateau[x2][y2] = 0;
		// }
		// } else if (plateau[x2][y2] == 2) {
		// if (plateau[x2 - 1][y2] == 1 && plateau[x2 + 1][y2] == 1 &&
		// plateau[x2][y2 + 1] == 1
		// && plateau[x2][y2 - 1] == 1) {
		// plateau[x2][y2] = 0;
		//
		// }
		//
		// }

		if (isDead(x2, y2, plateau, new boolean[taille][taille], plateau[x2][y2], taille)) {
			JOptionPane.showMessageDialog(this, "Stop !!!");
			plateau[x2][y2] = 0;
		}

	}

	public void paint(Graphics g, int chiffre) {
		// Dessine le plateau et les hoshi
		for (int i = 0; i <= (chiffre - 1) * 20; i += 20) {
			g.drawLine(0, i, (chiffre - 1) * 20, i);
			g.drawLine(i, 0, i, (chiffre - 1) * 20);
			if (chiffre == 9) {
				g.fillOval(chiffre * 20 / 2 - 15, chiffre * 20 / 2 - 15, 10, 10);
				g.fillOval(chiffre * 20 / 4 - 10, chiffre * 20 / 4 - 10, 10, 10);
				g.fillOval(chiffre * 20 / 4 - 10, chiffre * 20 / 4 + 70, 10, 10);
				g.fillOval(chiffre * 20 / 4 + 70, chiffre * 20 / 4 - 10, 10, 10);
				g.fillOval(chiffre * 20 / 4 + 70, chiffre * 20 / 4 + 70, 10, 10);
			}

			else if (chiffre == 13) {

				g.fillOval(chiffre * 20 / 2 - 15, chiffre * 20 / 2 - 15, 10, 10);

				g.fillOval(chiffre * 20 / 4 - 10, chiffre * 20 / 4 - 10, 10, 10);
				g.fillOval(chiffre * 20 / 4 - 10, chiffre * 20 / 4 + 110, 10, 10);
				g.fillOval(chiffre * 20 / 4 + 110, chiffre * 20 / 4 - 10, 10, 10);
				g.fillOval(chiffre * 20 / 4 + 110, chiffre * 20 / 4 + 110, 10, 10);
			} else if (chiffre == 19) {
				g.fillOval(chiffre * 20 / 2 - 15, chiffre * 20 / 2 - 15, 10, 10);
				g.fillOval(chiffre * 20 / 2 - 15, chiffre * 20 / 2 - 135, 10, 10);
				g.fillOval(chiffre * 20 / 2 - 15, chiffre * 20 / 2 + 125, 10, 10);
				g.fillOval(chiffre * 20 / 2 - 135, chiffre * 20 / 2 - 15, 10, 10);
				g.fillOval(chiffre * 20 / 2 - 135, chiffre * 20 / 2 - 135, 10, 10);
				g.fillOval(chiffre * 20 / 2 - 135, chiffre * 20 / 2 + 125, 10, 10);
				g.fillOval(chiffre * 20 / 2 + 105, chiffre * 20 / 2 - 15, 10, 10);
				g.fillOval(chiffre * 20 / 2 + 105, chiffre * 20 / 2 - 135, 10, 10);
				g.fillOval(chiffre * 20 / 2 + 105, chiffre * 20 / 2 + 125, 10, 10);
			}
		}

	}

	public void paintComponent(Graphics g) {

		// super.paintComponent(g);
		System.out.println(+plateau[3][3]);
		paint(g, taille);

		// On parcours la tableau du plateau, si on voit un chiffre, on dessine.
		// Mettez ici les icones que vous avez
		for (int j = 0; j < taille; j++) {
			for (int i = 0; i < taille; i++) {
				if (plateau[i][j] == 1) {
					g.drawOval(i * 20 - 5, j * 20 - 5, 10, 10);
				} else if (plateau[i][j] == 2) {
					g.fillOval(i * 20 - 5, j * 20 - 5, 10, 10);
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (numerobouton == 1) {
			// Le bouton qui annule un coup
			j = 299;

			for (; j >= 0; j--) {
				if (plateaux[j] != 0) { // Si le plateau des coups annulé a un
										// truc a l'interieur different de 0 (
										// SI on a joué un coup donc)
					System.out.println("Le joueur 1 a annulé coup en case :" + plateaux[j] + plateauy[j]);
					plateau[plateaux[j]][plateauy[j]] = 0; // On remet la case
															// du plateau
															// principâl a 0
															// car on a annulé
					desannulerx[numerodes] = plateaux[j]; // on met le ocup
															// annuler dans le
															// tableau
															// desannuler si on
															// veut desanuller
															// le coup
					desannulery[numerodes] = plateauy[j];
					numerodes++; // On incremente la valeur pour passer a la cas
									// esuivante

					plateaux[j] = 0; // Vu qu'on a annulé, on peut retirer le
										// coup dans le plateau qui annule donc
										// pour ne pas toujours re annuler le
										// meme coup
					plateauy[j] = 0;
					fenetre.repaint();
					j = 0;
				}

			}

		} else if (numerobouton == 2) {
			// Bouton desannuler. Probleme ici, si on desannule, ca remmetra que
			// des pierre du joueur actuel. Testez le pour voir
			j = 299;
			for (; j >= 0; j--) {
				if (desannulerx[j] != 0) { // Le reste fonctionne comme pour le
											// tableau qui annule un coup
					plateau[desannulerx[j]][desannulery[j]] = Joueur.numero;

					desannulerx[j] = 0;
					desannulery[j] = 0;

					fenetre.repaint();
					j = 0;

				}
			}
		} else if (numerobouton == 3) {
			// // Bouton finir. Si on clique dessus le Joueur change
			// if (Joueur.numero == 1) {
			// Joueur.numero = 2;
			// } else if (Joueur.numero == 2) {
			// Joueur.numero = 1;
			// }
		}
	}

	public void mouseClicked(MouseEvent e) {
		taille = Text.chiffreSize;
		if (plateau.length != taille) {
			plateau = new int[taille][taille];
		}

		// Definit la position du clique par rapport au tableau
		x = e.getX();
		y = e.getY();
		// x2 et y2 sont les cases du tableau a l'endroit ou on clique. Si on
		// clique sur la derniere case, x2 = 18 et y2 =18 par exemple
		x2 = (int) x / 20;
		y2 = (int) y / 20;
		int x3 = x % 20;
		int y3 = y % 20;
		if (x3 >= 10)
			x2++;
		if (y3 >= 10)
			y2++;

		if (x2 <= taille && y2 <= taille) { // SI l'endroit ou on clique est
											// dans le plateau
			if (plateau[x2][y2] != 0) {
				JOptionPane.showMessageDialog(this, "Stop !!!");
				return;
			}
			if (plateau[x2][y2] == 0 && x < (taille) * 20 && y < (taille) * 20) {
				// A chaque clique, en fonction du nemero du Joueur, on remplit
				// la case du tableau plateau du numero du Joueur qui clique. On
				// fait enssuite la fonciton supprimer qui evite le suicide, et
				// on rajoute le coupx dans plateaux et plateauy qui sont les
				// coup qu'on sauvegarde pour les annuler apres.
				if (Joueur.numero == 1) {
					System.out.println("Le joueur 1 a joué un coup en case : " + x2 + y2);

					plateau[x2][y2] = 1; // On met la case a l'endroit ou on
											// clique a 1 poru dire que y'a une
											// pierre dessus
					supprimer(x2, y2, plateau, taille); // On verifie le suicide
					plateaux[numero] = x2; // On rajoute le coup dans le plateua
											// qui annule
					plateauy[numero] = y2; // Meme chose
					numero++; // On increment la valeur du plateau qui annule
								// pour passer a la case suivante

				}

				else if (Joueur.numero == 2) {

					System.out.println("Le joueur 2 a joué un coup en case : " + x2 + y2);

					plateau[x2][y2] = 2;
					supprimer(x2, y2, plateau, taille);

					plateaux[numero] = x2;
					plateauy[numero] = y2;
					numero++;

				}

				if (plateau[x2][y2] != 0 && Joueur.numero == 1) {
					verifyAdversarialStates(taille, 2);
					Joueur.numero = 2;
				} else if (plateau[x2][y2] != 0 && Joueur.numero == 2) {
					verifyAdversarialStates(taille, 1);
					Joueur.numero = 1;
				}
			}

		}
		fenetre.repaint();
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public boolean isDead(int x, int y, int goban[][], boolean visited[][], int playerColor, int size) {

		visited[x][y] = true;
		if (x > 0 && !visited[x - 1][y]) {
			if (goban[x - 1][y] == 0)
				return false;
			if (goban[x - 1][y] == playerColor) {
				boolean dead = isDead(x - 1, y, goban, visited, playerColor, size);
				if (!dead)
					return false;
			}
		}
		if (x < (size - 1) && !visited[x + 1][y]) {
			if (goban[x + 1][y] == 0)
				return false;
			if (goban[x + 1][y] == playerColor) {
				boolean dead = isDead(x + 1, y, goban, visited, playerColor, size);
				if (!dead)
					return false;
			}
		}
		if (y > 0 && !visited[x][y - 1]) {
			if (goban[x][y - 1] == 0)
				return false;
			if (goban[x][y - 1] == playerColor) {
				boolean dead = isDead(x, y - 1, goban, visited, playerColor, size);
				if (!dead)
					return false;
			}
		}
		if (y < (size - 1) && !visited[x][y + 1]) {
			if (goban[x][y + 1] == 0)
				return false;
			if (goban[x][y + 1] == playerColor) {
				boolean dead = isDead(x, y + 1, goban, visited, playerColor, size);
				if (!dead)
					return false;
			}
		}
		return true;
	}

	public void verifyAdversarialStates(int size, int adversarialPlayer) {
		int plateau[][] = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				plateau[i][j] = this.plateau[i][j];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (this.plateau[i][j] == adversarialPlayer
						&& isDead(i, j, this.plateau, new boolean[size][size], adversarialPlayer, size)) {
					System.out.println("dead activated on " + adversarialPlayer + " at " + i + "." + j);
					plateau[i][j] = 0;
				}
			}
		}
		this.plateau = plateau;
	}
}

class Text implements ActionListener {
	// La classe des TextField qui retourne leur valeur pour la suite
	private JTextField taille;
	private JTextField handicap;
	private JFrame fenetre;
	public static int chiffreSize;
	public static String chiffreText = null;
	private int chiffreHandicap;

	Text(JTextField taille, JFrame fenetre) {
		this.taille = taille;
		this.fenetre = fenetre;

	}

	public JTextField getText() {
		return taille;
	}

	public void setText(JTextField taille) {
		this.taille = taille;
	}

	public int getChiffre() {
		return Integer.parseInt(taille.getText());
	}

	public void setChiffre(int chiffreSize) {
		this.chiffreSize = chiffreSize;
	}

	public void actionPerformed(ActionEvent event) {

		chiffreSize = Integer.parseInt(taille.getText());
		fenetre.setVisible(true);
	}

}

public class Jeux extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Jeux frame = new Jeux();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Jeux() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 481, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		int chiffre = 1;

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		Label label = new Label("Time Rule:");
		label.setBounds(10, 25, 62, 22);
		panel.add(label);

		/*
		 * Choice choice = new Choice(); choice.setBounds(132, 27, 116, 20);
		 * choice.addItem("None"); choice.addItem("Absolue");
		 * choice.addItem("Byo-Yoni"); panel.add(choice);
		 */
		Label label_1 = new Label("Size:");
		label_1.setBounds(10, 53, 62, 22);
		panel.add(label_1);

		/*
		 * Choice choice2 = new Choice(); choice2.setBounds(132, 55, 116, 20);
		 * choice2.addItem("9x9"); choice2.addItem("13x13");
		 * choice2.addItem("19x19"); panel.add(choice2);
		 */
		JTextField taille = new JTextField();
		taille.setBounds(132, 55, 116, 20);
		panel.add(taille);
		taille.setText("19");

		JTextField time = new JTextField();
		time.setBounds(132, 27, 116, 20);
		panel.add(time);
		Label label_2 = new Label("Black Player Name:");
		label_2.setBounds(10, 94, 116, 22);
		panel.add(label_2);

		Label label_3 = new Label("White Player Name:");
		label_3.setBounds(10, 122, 116, 22);
		panel.add(label_3);

		JFrame partie = new JFrame();
		partie.setLayout(null);
		partie.setSize(800, 800);

		Button startButton = new Button("Start");
		startButton.setBounds(178, 166, 70, 22);
		panel.add(startButton);
		startButton.addActionListener(new Text(taille, partie));

		Button quitter = new Button("Quitter");
		quitter.setBounds(178 + 75, 166, 70, 22);
		panel.add(quitter);
		quitter.addActionListener(new Quitter());

		Choice choice_1 = new Choice();
		choice_1.setBounds(132, 55, 116, 20);
		panel.add(choice_1);

		JTextField textField = new JTextField();
		textField.setBounds(132, 94, 116, 22);
		panel.add(textField);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(132, 122, 116, 22);
		panel.add(textField_1);

		JPanel partiepanel = new JPanel();

		JPanel boutonpanel = new JPanel();

		Button annuler = new Button("Annuler");
		annuler.setBounds(100, 100, 70, 22);
		boutonpanel.add(annuler);
		annuler.addActionListener(new Goban(textField_1, partie, 1));

		Button desannuler = new Button("Desannuler");
		annuler.setBounds(200, 200, 80, 80);
		boutonpanel.add(desannuler);
		desannuler.addActionListener(new Goban(textField_1, partie, 2));

		Button finir = new Button("Finir");
		finir.setBounds(300, 300, 80, 80);
		boutonpanel.add(finir);
		finir.addActionListener(new Goban(textField_1, partie, 3));
		Text text = new Text(taille, partie);

		boutonpanel.setBounds(380, 380, 400, 400);

		partie.add(boutonpanel);
		Goban go = new Goban(textField_1, partie, 1);
		go.addMouseListener(go);

		go.setBounds(0, 0, 500, 500);
		partie.add(go);
		// Dans la JFrame partie, onr ajoute le panel qui gere les boutons et un
		// objet de type go qui gere le plateau

	}
}
