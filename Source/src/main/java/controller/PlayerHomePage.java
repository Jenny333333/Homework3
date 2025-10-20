package controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerHomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerHomePage frame = new PlayerHomePage("username");
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
	public PlayerHomePage(String username) {
		this.username = username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(28, 22, 70, 62);
		contentPane.add(lblNewLabel);
		
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
		
		JLabel lblNewLabel_2 = new JLabel(username);
		lblNewLabel_2.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(120, 39, 151, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("星星:");
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(291, 55, 58, 29);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("戰績");
		btnNewButton.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				History history=new History(username);
				history.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(71, 114, 84, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("成就");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton_1.setBounds(201, 114, 84, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("排行榜");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton_2.setBounds(139, 167, 84, 22);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("返回");
		btnNewButton_3.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GameHomePage gameHomePage=new GameHomePage(username);
				gameHomePage.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(342, 219, 84, 22);
		contentPane.add(btnNewButton_3);

	}

}
