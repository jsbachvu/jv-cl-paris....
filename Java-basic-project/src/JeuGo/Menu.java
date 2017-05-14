package JeuGo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Choice;
import java.awt.Button;
import java.awt.TextField;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Label label = new Label("Time Rule:");
		label.setBounds(10, 25, 62, 22);
		panel.add(label);
		
		Choice choice = new Choice();
		choice.setBounds(132, 27, 116, 20);
		panel.add(choice);
		
		Label label_1 = new Label("Size:");
		label_1.setBounds(10, 53, 62, 22);
		panel.add(label_1);
		
		Label label_2 = new Label("Black Player Name:");
		label_2.setBounds(10, 94, 116, 22);
		panel.add(label_2);
		
		Label label_3 = new Label("White Player Name:");
		label_3.setBounds(10, 122, 116, 22);
		panel.add(label_3);
		
		Button startButton = new Button("Start");
		startButton.setBounds(178, 166, 70, 22);
		panel.add(startButton);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(132, 55, 116, 20);
		panel.add(choice_1);
		
		TextField textField = new TextField();
		textField.setBounds(132, 94, 116, 22);
		panel.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(132, 122, 116, 22);
		panel.add(textField_1);
		
		
	}
}
