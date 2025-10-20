package controller;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Component;
import java.awt.Image;




import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Player;
import service.impl.PlayerServiceImpl;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private PlayerServiceImpl psi=new PlayerServiceImpl();
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		name.setBounds(255, 76, 96, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		username.setBounds(87, 76, 96, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		password.setBounds(87, 128, 96, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
		btnNewButton_1.setBounds(182, 218, 84, 22);
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
				String Picture=(String) comboBox.getSelectedItem();
				
				Player player=new Player(Name,Username,Password, Picture);
				
				if(psi.addPlayer(player)==1)
				{
					AddPlayerError addplayererror=new AddPlayerError();
					addplayererror.setVisible(true);
					dispose();
				}
				else
				{
					AddPlayerSuccess addplayersuccess=new AddPlayerSuccess();
					addplayersuccess.setVisible(true);
					dispose();
				}
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel picture = new JLabel("");
		picture.setBounds(353, 50, 73, 64);
		contentPane.add(picture);
	
        
        String[] pictureFiles = { "picture1.png", "picture2.png", "picture3.png", "picture4.png", "picture5.png", "picture6.png", "picture7.png", "picture8.png" };
        String[] pictureName = { "表情一", "表情二", "小螃蟹", "紙鶴", "四葉草", "月亮", "星星", "氣球" };
        ImageIcon[] icons = new ImageIcon[pictureFiles.length];

        for (int i = 0; i < pictureFiles.length; i++) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Image/" + pictureFiles[i]));
            Image scaledImage = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            icons[i] = new ImageIcon(scaledImage);
        }

       comboBox = new JComboBox<>(pictureName); 
       comboBox.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
       comboBox.setBounds(282, 127, 144, 22);
        comboBox.addActionListener(e -> {
            int selectedIndex = comboBox.getSelectedIndex();
            if (selectedIndex >= 0 && icons[selectedIndex] != null) {
                picture.setIcon(icons[selectedIndex]); 
            }
        });
        contentPane.add(comboBox);
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (index >= 0 && index < icons.length) {
                    label.setIcon(icons[index]);
                }
                return label;
            }
        });
        
        lblNewLabel = new JLabel("選擇頭貼");
        lblNewLabel.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(204, 128, 84, 20);
        contentPane.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("註冊");
        lblNewLabel_1.setFont(new Font("源泉圓體 M", Font.BOLD, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(182, 10, 84, 34);
        contentPane.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("姓名:");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(204, 76, 52, 20);
        contentPane.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("帳號:");
        lblNewLabel_3.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(38, 76, 51, 20);
        contentPane.add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("密碼:");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("源泉圓體 M", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(38, 125, 57, 27);
        contentPane.add(lblNewLabel_4);
	}
        }
