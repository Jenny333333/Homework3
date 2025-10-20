package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Admin;
import service.impl.AdminServiceImpl;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdminLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JLabel lblNewLabel;
	private AdminServiceImpl asi=new AdminServiceImpl();
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		username.setBounds(196, 95, 96, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		password.setBounds(196, 133, 96, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				
				Admin admin=asi.Login(Username, Password);
				
				if(admin!=null)
				{
					AdminHomePage success = new AdminHomePage(admin.getUsername());
					success.setVisible(true);
					dispose();
				}
				else
				{
					LoginError error=new LoginError();
					error.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(256, 186, 84, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("點我註冊");
		btnNewButton_2.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminRegister adminRegister=new AdminRegister();
				adminRegister.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(111, 186, 84, 22);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("管理員登入");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("源泉圓體 M", Font.BOLD, 20));
		lblNewLabel.setBounds(149, 22, 143, 39);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(149, 93, 46, 20);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("密碼:");
		lblNewLabel_2.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(149, 131, 46, 20);
		contentPane.add(lblNewLabel_2);

	}
}
