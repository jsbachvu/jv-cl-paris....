package View;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Control;
import Model.Player;

public class Menu extends JFrame {

	private JPanel contentPane;
	Control control;

	/**
	 * Create the frame.
	 */
	public Menu(Control control) {
		super("Jeu Goban - Menu");
		this.control = control;
//		this.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		Label label = new Label("Time Rule:");
		label.setBounds(7, 10, 62, 22);
		panel.add(label);

		Choice timeRuleChoice = new Choice();
		timeRuleChoice.setBounds(129, 12, 116, 20);
		timeRuleChoice.addItem("Aucune horloge");
		timeRuleChoice.addItem("Horloge absolute");
		timeRuleChoice.addItem("Byo-Yomi");
		panel.add(timeRuleChoice);

		Label label_1 = new Label("Size:");
		label_1.setBounds(7, 38, 62, 22);
		panel.add(label_1);

		Label label_2 = new Label("Black Player Name:");
		label_2.setBounds(7, 102, 116, 22);
		panel.add(label_2);

		Label label_3 = new Label("White Player Name:");
		label_3.setBounds(7, 130, 116, 22);
		panel.add(label_3);

		Button startButton = new Button("Start");
		
		startButton.setBounds(175, 175, 70, 22);
		panel.add(startButton);

		Choice sizeChoice = new Choice();
		sizeChoice.setBounds(129, 40, 116, 20);
		sizeChoice.addItem("9x9");
		sizeChoice.addItem("13x13");
		sizeChoice.addItem("19x19");
		panel.add(sizeChoice);

		TextField blackName = new TextField();
		blackName.setText("black");
		blackName.setBounds(129, 102, 116, 22);
		panel.add(blackName);

		TextField whiteName = new TextField();
		whiteName.setText("white");
		whiteName.setBounds(129, 130, 116, 22);
		panel.add(whiteName);

		Button quitButton = new Button("Quit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Quit game
			}
		});
		quitButton.setBounds(10, 175, 70, 22);
		panel.add(quitButton);

		Label label_4 = new Label("Handicap:");
		label_4.setBounds(7, 66, 62, 22);
		panel.add(label_4);

		JCheckBox handicapCheckbox = new JCheckBox("Handicap?");
		handicapCheckbox.setBounds(129, 66, 95, 22);
		panel.add(handicapCheckbox);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (handicapCheckbox.isSelected()) {
					// TODO: create handicaps
				} else {
					control.playGame(
							new Player("" + blackName.getText(), Control.BLACK_PLAYER), 
							new Player("" + whiteName.getText(), Control.WHITE_PLAYER), 
							timeRuleChoice.getSelectedIndex(), 
							sizeChoice.getSelectedIndex(), 
							null);
				}
			}
		});
	}
}
