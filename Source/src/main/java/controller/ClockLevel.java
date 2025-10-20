package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ClockLevel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockLevel frame = new ClockLevel("username");
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
	public ClockLevel(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("初級");
		btnNewButton.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CBRule cBRule=new CBRule(username);
				cBRule.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(103, 114, 73, 73);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("高級");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		/*btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CARule cARule=new CARule(username);
				cARule.setVisible(true);
				dispose();
			}
		});*/
		btnNewButton_1.setBounds(240, 114, 73, 73);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("難度選擇");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("源泉圓體 M", Font.BOLD, 20));
		lblNewLabel.setBounds(161, 33, 107, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GameHomePage gameHomePage=new GameHomePage(username);
				gameHomePage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(331, 231, 84, 22);
		contentPane.add(btnNewButton_2);

	}

}
