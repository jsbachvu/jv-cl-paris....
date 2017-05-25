package View;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Control.Control;
import Model.JButtonGame;
import Model.Player;
import Model.Step;

public class GobanView extends JFrame {

	private JPanel contentPane;
	private JTextField time1;
	private JTextField time2;
	Control control;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// GobanView frame = new GobanView(
	// new Player("B", Goban.BLACK_PLAYER),
	// new Player("A", Goban.WHITE_PLAYER),
	// Goban.ABSOLUTE_RULE,
	// Goban.SIZE_TYPE_19x19, null, null);
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public GobanView(Player blackPlayer, Player whitePlayer, int timeRule, int size, Step[] handicapSteps,
			Control control) {
		super("Jeu Goban - Play");
		this.setVisible(false);
		this.control = control;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel centrePanel = new JPanel();
		centrePanel.setLayout(new GridLayout(19, 19, 0, 0));
		centrePanel.setBounds(15, 84, 296, 176);
		centrePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, false));

		contentPane.add(centrePanel);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 396, 68);
		contentPane.add(panel);
		panel.setLayout(null);

		Label whiteName = new Label("Name 1");
		whiteName.setBounds(290, 5, 62, 22);
		panel.add(whiteName);

		Label blackName = new Label("Name 2");
		blackName.setBounds(10, 5, 62, 22);
		panel.add(blackName);

		time1 = new JTextField();
		time1.setEditable(false);
		time1.setBounds(10, 33, 57, 20);
		panel.add(time1);
		time1.setColumns(10);

		time2 = new JTextField();
		time2.setEditable(false);
		time2.setColumns(10);
		time2.setBounds(295, 33, 57, 20);
		panel.add(time2);

		Button backButton = new Button("<--");
		backButton.setBounds(108, 33, 50, 22);
		panel.add(backButton);

		Button forwadButton = new Button("-->");
		forwadButton.setBounds(183, 31, 50, 22);
		panel.add(forwadButton);

		// Show information
		whiteName.setText(whitePlayer.getName());
		blackName.setText(blackPlayer.getName());

		// Show Goban Map
		JButtonGame buttons[][] = new JButtonGame[control.getMap().length][control.getMap().length];
		switch (size) {
		case Control.SIZE_TYPE_13x13:
			centrePanel.setSize(273, 273);
			centrePanel.setLayout(new GridLayout(13, 13, -1, -1));
			break;
		case Control.SIZE_TYPE_19x19:
			System.out.println("19x19");
			centrePanel.setSize(399, 399);
			centrePanel.setLayout(new GridLayout(19, 19, -1, -1));
			break;
		case Control.SIZE_TYPE_9x9:
			centrePanel.setSize(189, 189);
			centrePanel.setLayout(new GridLayout(9, 9, -1, -1));
			break;
		}
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons.length; j++) {
				buttons[i][j] = new JButtonGame(i, j, false);
				buttons[i][j].addActionListener(new JButtonGameActionListener());
				centrePanel.add(buttons[i][j]);
			}
		}
		// TODO: uncomment to set Hoshi
		// for (int[] hoshi: control.getHoshi()) {
		// buttons[hoshi[0]][hoshi[1]].setHoshi(true);
		// }

		// TODO: Set time rule

		// TODO: Create ActionListener for Step backing
	}

	class JButtonGameActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButtonGame jButton = (JButtonGame) e.getSource();
			// TODO: check duplicated, rule, ...
			jButton.beClicked(control.getStepFlag());
			control.invertStepFlag();
		}

	}
}
