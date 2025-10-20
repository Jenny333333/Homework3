package controller;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminHomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomePage frame = new AdminHomePage("username");
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
	public AdminHomePage(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("歡迎：" + username);
		welcomeLabel.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		welcomeLabel.setBounds(10, 3, 189, 20);
		contentPane.add(welcomeLabel);
		
		JLabel time = new JLabel();
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		time.setBounds(246, 10, 178, 19);
		contentPane.add(time);
		Timer timer = new Timer(1000, e->{
		String currentTime = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date());
		time.setText(currentTime);
		});
		timer.start();
		
		JButton btnNewButton = new JButton("帳號管理");
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		/*btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AAccount aAccount=new AAccount();
				aAccount.setVisible(true);
				dispose();
			}
		});*/
		btnNewButton.setBounds(79, 98, 84, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("遊玩資料");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		/*btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AData aData=new AData();
				aData.setVisible(true);
				dispose();
			}
		});*/
		btnNewButton_1.setBounds(252, 98, 84, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("時鐘題庫");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		/*btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClockQ clockQ=new ClockQ();
				clockQ.setVisible(true);
				dispose();
			}
		});*/
		btnNewButton_2.setBounds(79, 148, 84, 22);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("購物題庫");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		/*btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShoppingQ shoppingQ=new ShoppingQ();
				shoppingQ.setVisible(true);
				dispose();
			}
		});*/
		btnNewButton_3.setBounds(252, 148, 84, 22);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("登出");
		btnNewButton_4.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login=new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(328, 231, 84, 22);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("兒童學習系統 管理");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("源泉圓體 M", Font.BOLD, 20));
		lblNewLabel.setBounds(79, 39, 265, 37);
		contentPane.add(lblNewLabel);

	}

}
