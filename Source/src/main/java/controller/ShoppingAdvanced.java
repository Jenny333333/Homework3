package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class ShoppingAdvanced extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingAdvanced frame = new ShoppingAdvanced();
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
	public ShoppingAdvanced() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(146, 10, 126, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(329, 10, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 52, 54, 56);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 120, 54, 56);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(10, 188, 54, 56);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(146, 54, 54, 56);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(146, 120, 54, 56);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(146, 188, 54, 56);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(274, 52, 60, 56);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(274, 123, 60, 53);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(274, 188, 60, 53);
		contentPane.add(lblNewLabel_10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 254, 394, 92);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(0, 356, 46, 34);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(60, 356, 46, 34);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(116, 356, 46, 34);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(177, 356, 38, 39);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setBounds(226, 356, 46, 39);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setBounds(282, 354, 46, 36);
		contentPane.add(lblNewLabel_16);
		
		JButton btnNewButton = new JButton("清除");
		btnNewButton.setBounds(342, 350, 84, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("送出");
		btnNewButton_1.setBounds(342, 385, 84, 22);
		contentPane.add(btnNewButton_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(78, 70, 28, 22);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(74, 138, 28, 22);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(74, 206, 28, 22);
		contentPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(210, 70, 28, 22);
		contentPane.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(210, 138, 28, 22);
		contentPane.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(210, 206, 28, 22);
		contentPane.add(spinner_5);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(353, 70, 28, 22);
		contentPane.add(spinner_6);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(353, 138, 28, 22);
		contentPane.add(spinner_7);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setBounds(353, 206, 28, 22);
		contentPane.add(spinner_8);
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.setBounds(10, 386, 28, 22);
		contentPane.add(spinner_9);
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.setBounds(70, 386, 28, 22);
		contentPane.add(spinner_10);
		
		JSpinner spinner_11 = new JSpinner();
		spinner_11.setBounds(126, 386, 28, 22);
		contentPane.add(spinner_11);
		
		JSpinner spinner_12 = new JSpinner();
		spinner_12.setBounds(172, 386, 28, 22);
		contentPane.add(spinner_12);
		
		JSpinner spinner_13 = new JSpinner();
		spinner_13.setBounds(236, 386, 28, 22);
		contentPane.add(spinner_13);
		
		JSpinner spinner_14 = new JSpinner();
		spinner_14.setBounds(282, 386, 28, 22);
		contentPane.add(spinner_14);
		
		JButton btnNewButton_2 = new JButton("提示");
		btnNewButton_2.setBounds(14, 16, 84, 22);
		contentPane.add(btnNewButton_2);

	}
}
