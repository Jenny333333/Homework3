package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class ShoppingBeginner extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingBeginner frame = new ShoppingBeginner();
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
	public ShoppingBeginner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("購物小能手 初級");
		lblNewLabel.setBounds(143, 10, 137, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(307, 10, 119, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(24, 54, 55, 59);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(24, 134, 55, 59);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(24, 203, 55, 59);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(131, 54, 60, 59);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(129, 134, 62, 59);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(131, 203, 60, 59);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(259, 54, 55, 59);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(259, 140, 55, 59);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(259, 209, 55, 59);
		contentPane.add(lblNewLabel_10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(24, 258, 363, 96);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(10, 364, 28, 36);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(95, 364, 60, 36);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(171, 364, 55, 36);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(245, 364, 55, 36);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setBounds(307, 364, 46, 36);
		contentPane.add(lblNewLabel_15);
		
		JButton btnNewButton = new JButton("送出");
		btnNewButton.setBounds(352, 388, 84, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("清除");
		btnNewButton_1.setBounds(352, 356, 84, 22);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setBounds(49, 364, 36, 36);
		contentPane.add(lblNewLabel_16);
		
		JButton btnNewButton_2 = new JButton("提示");
		btnNewButton_2.setBounds(24, 16, 84, 22);
		contentPane.add(btnNewButton_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(89, 73, 28, 22);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(89, 153, 28, 22);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(77, 222, 28, 22);
		contentPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(201, 73, 28, 22);
		contentPane.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(198, 153, 28, 22);
		contentPane.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(198, 222, 28, 22);
		contentPane.add(spinner_5);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(325, 73, 28, 22);
		contentPane.add(spinner_6);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(325, 153, 28, 22);
		contentPane.add(spinner_7);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setBounds(307, 222, 28, 22);
		contentPane.add(spinner_8);
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.setBounds(10, 389, 28, 22);
		contentPane.add(spinner_9);
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.setBounds(51, 389, 28, 22);
		contentPane.add(spinner_10);
		
		JSpinner spinner_11 = new JSpinner();
		spinner_11.setBounds(105, 389, 28, 22);
		contentPane.add(spinner_11);
		
		JSpinner spinner_12 = new JSpinner();
		spinner_12.setBounds(181, 389, 28, 22);
		contentPane.add(spinner_12);
		
		JSpinner spinner_13 = new JSpinner();
		spinner_13.setBounds(255, 389, 28, 22);
		contentPane.add(spinner_13);
		
		JSpinner spinner_14 = new JSpinner();
		spinner_14.setBounds(317, 389, 28, 22);
		contentPane.add(spinner_14);

	}

}
