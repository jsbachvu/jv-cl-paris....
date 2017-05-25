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
import javax.swing.JButton;
import javax.swing.ImageIcon;

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
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Label label = new Label("Time Rule:");
		label.setBounds(10, 25, 62, 22);
		panel.add(label);
		
		Choice choice = new Choice();
		choice.setBounds(132, 27, 116, 20);
		choice.addItem("A");
		choice.addItem("B");
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setEnabled(false);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\BOB-\\Desktop\\button.png"));
		btnNewButton.setBounds(69, 199, 22, 21);
		btnNewButton.setBorderPainted(false);
		panel.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setIcon(new ImageIcon("C:\\Users\\BOB-\\Desktop\\button.png"));
		button.setBounds(69, 180, 22, 21);
		button.setBorderPainted(false);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\BOB-\\Desktop\\button3.png"));
		button_1.setBorderPainted(false);
		button_1.setBounds(90, 199, 22, 21);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\BOB-\\Desktop\\button.png"));
		button_2.setEnabled(false);
		button_2.setBorderPainted(false);
		button_2.setBounds(90, 180, 22, 21);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("C:\\Users\\BOB-\\Desktop\\button.png"));
		button_3.setEnabled(false);
		button_3.setBorderPainted(false);
		button_3.setBounds(111, 199, 22, 21);
		panel.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon("C:\\Users\\BOB-\\Desktop\\button.png"));
		button_4.setEnabled(false);
		button_4.setBorderPainted(false);
		button_4.setBounds(111, 180, 22, 21);
		panel.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon("C:\\Users\\BOB-\\Desktop\\button.png"));
		button_5.setEnabled(false);
		button_5.setBorderPainted(false);
		button_5.setBounds(69, 219, 22, 21);
		panel.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon("C:\\Users\\BOB-\\Desktop\\button.png"));
		button_6.setEnabled(false);
		button_6.setBorderPainted(false);
		button_6.setBounds(90, 219, 22, 21);
		panel.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setEnabled(false);
		button_7.setBorderPainted(false);
		button_7.setBounds(141, 219, 22, 21);
		panel.add(button_7);
		
		
	}
}
