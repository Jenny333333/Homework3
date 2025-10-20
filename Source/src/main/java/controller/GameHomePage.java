package controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameHomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameHomePage frame = new GameHomePage("username");
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
	public GameHomePage(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("時間管理大師");
		btnNewButton.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClockLevel clockLevel=new ClockLevel(username);
				clockLevel.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(44, 129, 144, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("購物小能手");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		/*btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShoppingLevel shoppingLevel=new ShoppingLevel(username);
				shoppingLevel.setVisible(true);
				dispose();
			}
		});*/
		btnNewButton_1.setBounds(239, 129, 144, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel welcomeLabel = new JLabel("歡迎：" + username);
		welcomeLabel.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		welcomeLabel.setBounds(10, 8, 189, 20);
		contentPane.add(welcomeLabel);
		
		JLabel time = new JLabel();
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		time.setBounds(268, 10, 158, 19);
		contentPane.add(time);
		Timer timer = new Timer(1000, e->{
		String currentTime = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date());
		time.setText(currentTime);
		});
		timer.start();
		
		JButton btnNewButton_2 = new JButton("登出");
		btnNewButton_2.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login=new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(340, 231, 84, 22);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("個人主頁");
		btnNewButton_3.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlayerHomePage playerHomePage=new PlayerHomePage(username);
				playerHomePage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 231, 84, 22);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("兒童學習系統");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("源泉圓體 M", Font.BOLD, 20));
		lblNewLabel.setBounds(111, 52, 207, 44);
		contentPane.add(lblNewLabel);

	}
}
