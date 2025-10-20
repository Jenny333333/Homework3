package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ShoppingIntermideate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingIntermideate frame = new ShoppingIntermideate();
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
	public ShoppingIntermideate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("購物小能手 中級");
		lblNewLabel.setBounds(135, 10, 140, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(335, 10, 91, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(22, 49, 46, 54);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(22, 122, 46, 54);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(22, 186, 46, 54);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(148, 69, 52, 54);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(148, 142, 52, 54);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(148, 206, 46, 47);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(239, 53, 58, 54);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(239, 126, 58, 50);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(239, 186, 58, 67);
		contentPane.add(lblNewLabel_10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(78, 66, 28, 22);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(78, 139, 28, 22);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(78, 203, 28, 22);
		contentPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(201, 86, 28, 22);
		contentPane.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(201, 159, 28, 22);
		contentPane.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(204, 218, 28, 22);
		contentPane.add(spinner_5);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(295, 66, 28, 22);
		contentPane.add(spinner_6);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(295, 139, 28, 22);
		contentPane.add(spinner_7);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setBounds(295, 203, 28, 22);
		contentPane.add(spinner_8);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 256, 367, 97);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(22, 363, 46, 33);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(78, 363, 58, 33);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(135, 363, 64, 45);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(251, 363, 36, 45);
		contentPane.add(lblNewLabel_14);
		
		JButton btnNewButton = new JButton("送出");
		btnNewButton.setBounds(342, 386, 84, 22);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setBounds(213, 363, 28, 45);
		contentPane.add(lblNewLabel_15);
		
		JButton btnNewButton_1 = new JButton("清除");
		btnNewButton_1.setBounds(342, 352, 84, 22);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setBounds(295, 363, 28, 45);
		contentPane.add(lblNewLabel_16);
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.setBounds(32, 396, 28, 22);
		contentPane.add(spinner_9);
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.setBounds(78, 387, 28, 22);
		contentPane.add(spinner_10);
		
		JSpinner spinner_11 = new JSpinner();
		spinner_11.setBounds(145, 396, 28, 22);
		contentPane.add(spinner_11);
		
		JSpinner spinner_12 = new JSpinner();
		spinner_12.setBounds(201, 396, 28, 22);
		contentPane.add(spinner_12);
		
		JSpinner spinner_13 = new JSpinner();
		spinner_13.setBounds(247, 396, 28, 22);
		contentPane.add(spinner_13);
		
		JSpinner spinner_14 = new JSpinner();
		spinner_14.setBounds(295, 387, 28, 22);
		contentPane.add(spinner_14);

	}
}
