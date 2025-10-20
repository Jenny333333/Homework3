package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShoppingLevel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingLevel frame = new ShoppingLevel("username");
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
	public ShoppingLevel(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("初級");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SBRule sBRule=new SBRule(username);
				sBRule.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(31, 80, 97, 105);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("中級");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SIRule sIRule=new SIRule(username);
				sIRule.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(158, 76, 106, 109);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("高級");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SARule sARule=new SARule(username);
				sARule.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(298, 80, 106, 105);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("難度選擇");
		lblNewLabel.setBounds(147, 25, 146, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("返回");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GameHomePage gameHomePage=new GameHomePage(username);
				gameHomePage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(342, 231, 84, 22);
		contentPane.add(btnNewButton_3);

	}

}
