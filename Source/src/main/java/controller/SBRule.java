package controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SBRule extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SBRule frame = new SBRule("username");
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
	public SBRule(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("遊戲規則");
		lblNewLabel.setBounds(127, 22, 152, 28);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(43, 60, 326, 100);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("開始遊戲");
		btnNewButton.setBounds(163, 198, 84, 22);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShoppingLevel shoppingLevel=new ShoppingLevel(username);
				shoppingLevel.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(342, 220, 84, 22);
		contentPane.add(btnNewButton_1);
	}

}
