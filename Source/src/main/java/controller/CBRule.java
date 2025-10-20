package controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.GameLevelDao;
import dao.impl.GameLevelDaoImpl;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CBRule extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CBRule frame = new CBRule("username");
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
	public CBRule(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("開始遊戲");
		btnNewButton.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClockBeginner clockBeginner=new ClockBeginner(username);
				clockBeginner.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(176, 189, 84, 22);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("遊戲規則");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("源泉圓體 M", Font.BOLD, 20));
		lblNewLabel.setBounds(156, 20, 117, 34);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClockLevel clockLevel=new ClockLevel(username);
				clockLevel.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(342, 231, 84, 22);
		contentPane.add(btnNewButton_1);
		
		GameLevelDaoImpl dao = new GameLevelDaoImpl(); 
		String description = dao.findDescriptionById(1);
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		textArea.setText(description);
		textArea.setBounds(68, 79, 311, 82);
		contentPane.add(textArea);
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true);  
		contentPane.add(textArea);

		
	}

}
