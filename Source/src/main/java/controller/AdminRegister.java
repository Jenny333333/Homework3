package controller;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Admin;
import service.impl.AdminServiceImpl;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdminRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private AdminServiceImpl asi=new AdminServiceImpl();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegister frame = new AdminRegister();
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
	public AdminRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		name.setBounds(153, 97, 96, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		username.setBounds(153, 127, 96, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		password.setBounds(153, 157, 96, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				
				Admin admin=new Admin(Name,Username,Password);
				
				if(asi.addAdmin(admin)==1)
				{
					AddAdminError addadminerror=new AddAdminError();
					addadminerror.setVisible(true);
					dispose();
				}
				else
				{
					AddAdminSuccess addadminsuccess=new AddAdminSuccess();
					addadminsuccess.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBounds(296, 110, 66, 52);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("管理員註冊");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("源泉圓體 M", Font.BOLD, 20));
		lblNewLabel.setBounds(119, 22, 165, 41);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(108, 95, 46, 20);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("帳號:");
		lblNewLabel_2.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(108, 125, 46, 21);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("密碼:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(108, 157, 46, 17);
		contentPane.add(lblNewLabel_3);
	
	}
        }
