package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.GameLevelDaoImpl;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CARule extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CARule frame = new CARule("username");
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
	public CARule(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("開始遊戲");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClockAdvanced clockAdvanced=new ClockAdvanced(username);
				clockAdvanced.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(205, 201, 84, 22);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("遊戲規則");
		lblNewLabel.setBounds(155, 5, 106, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClockLevel clockLevel=new ClockLevel(username);
				clockLevel.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(342, 220, 84, 22);
		contentPane.add(btnNewButton_1);

		GameLevelDaoImpl dao = new GameLevelDaoImpl(); 
		String description = dao.findDescriptionById(3);
		JTextArea textArea = new JTextArea();
		textArea.setText(description);
		textArea.setBounds(44, 36, 340, 119);
		contentPane.add(textArea);
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true);  
		contentPane.add(textArea);
	}

}
