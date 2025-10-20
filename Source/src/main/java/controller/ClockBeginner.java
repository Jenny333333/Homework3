package controller;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import model.Record;
import service.ClockService;
import service.RecordService;
import dao.impl.ClockDaoImpl;
import dao.impl.PlayerDaoImpl;
import dao.ClockDao;
import dao.PlayerDao;
import model.Clock;
import model.Player;
import service.impl.ClockServiceImpl;
import service.impl.RecordServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ClockBeginner extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Clock currentClock;
	private ClockService clockService = new ClockServiceImpl(new ClockDaoImpl());
	private LocalDateTime startTime; 
	private int userId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockBeginner frame = new ClockBeginner("username");
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
	public ClockBeginner(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		PlayerDaoImpl pdi = new PlayerDaoImpl();
		Player player =pdi.selectByUsername(username);
		this.userId = player.getId();
		
		JLabel lblNewLabel = new JLabel("時間管理大師 初級");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("源泉圓體 M", Font.BOLD, 20));
		lblNewLabel.setBounds(110, 10, 190, 37);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("注意是早上還是下午哦");
		textArea.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		textArea.setBounds(62, 51, 319, 48);
		contentPane.add(textArea);
		
		JLabel clockImage = new JLabel("");
		clockImage.setBounds(134, 109, 166, 154);
		contentPane.add(clockImage);
		
		
		
		
		JLabel time = new JLabel();
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		time.setBounds(304, 0, 132, 19);
		contentPane.add(time);
		Timer timer = new Timer(1000, e->{
		String currentTime = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date());
		time.setText(currentTime);
		});
		timer.start();
		
		
		  

		
		ClockDaoImpl clockDaoImpl = new ClockDaoImpl();
		Clock clock = clockDaoImpl.getRandomClockByLevel("初級");
		LocalDateTime startTime = LocalDateTime.now();
		currentClock = clock;
		String imagePath = clock.getImage();

		if (imagePath != null) {
		    ImageIcon icon = new ImageIcon(getClass().getResource("/Image/Clock/" + imagePath));
		    Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH); 
		    clockImage.setIcon(new ImageIcon(img));
		}

		
		JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
		timeSpinner.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
	    JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
	    timeSpinner.setEditor(timeEditor);
	    timeSpinner.setBounds(331, 186, 83, 22);
	contentPane.add(timeSpinner);
		
		
		JButton btnNewButton = new JButton("送出");
		btnNewButton.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LocalDateTime endTime = LocalDateTime.now();
				 Date selectedDate = (Date) timeSpinner.getValue();
			        LocalTime inputTime = selectedDate.toInstant()
			                .atZone(ZoneId.systemDefault())
			                .toLocalTime()
			                .withSecond(0)
			                .withNano(0);

			        ClockServiceImpl csi = new ClockServiceImpl(new ClockDaoImpl());
			        int star = csi.checkAnswerLevel(currentClock, inputTime);

			        Duration duration = Duration.between(startTime, endTime);
			        int durationSeconds = (int) duration.getSeconds();

			     
			        int userId = ClockBeginner.this.userId;
			        int gameId = 2;  
			        int levelId = 1; 

			       
			        
			        if (star == 3) {
			                JOptionPane.showMessageDialog(null, "太棒啦～ 答對了！\n獲得★★★");
			        } else if (star == 2) {
			                JOptionPane.showMessageDialog(null, "加油～ 差一點點！\n獲得★★\n正確答案是 "+currentClock.getAnswer());
			        } else if (star == 1) {
			                JOptionPane.showMessageDialog(null, "加油～ 差一點！\n獲得★\n正確答案是 "+currentClock.getAnswer());
			        } else {
			                JOptionPane.showMessageDialog(null, "啊哦～ 答錯了！\n正確答案是 "+currentClock.getAnswer());
			        }
			        Record record = new Record(userId, gameId, levelId, star, startTime, endTime);
			        RecordService rs = new RecordServiceImpl();
			        rs.saveRecord(record);
			    }
			});
		btnNewButton.setBounds(331, 218, 84, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClockLevel clockLevel=new ClockLevel(username);
				clockLevel.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 218, 84, 22);
		contentPane.add(btnNewButton_1);
	}
}
