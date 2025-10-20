package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.impl.Vw_recordDaoImpl;
import model.Vw_record;
import service.RecordService;
import service.Vw_recordService;
import service.impl.RecordServiceImpl;
import service.impl.Vw_recordServiceImpl;
import util.CreateExcel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class History extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;

    private String player; 
    private String username;
    private List<Vw_record> currentRecords;

    
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History("username");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public History(String username)  {
    	this.username = username;
        this.player = username;
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 729, 405);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        String[] columnNames = {"Game", "Level", "Star", "Start Time", "End Time", "Duration"};

        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        Vw_recordServiceImpl vw = new Vw_recordServiceImpl();
        List<Vw_record> vw_records = new Vw_recordDaoImpl().selectByPlayer(player);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        
        for (Vw_record v : vw_records) {
            Object[] rowData = {
                v.getGame(),
                v.getLevel(),
                v.getStar(),
                v.getStartTime().format(formatter),
                v.getEndTime().format(formatter),
                v.getDuration()
            };
            tableModel.addRow(rowData);
            currentRecords=vw_records;
        }
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 5, 710, 282);
        contentPane.add(scrollPane);
        
        JButton btnNewButton = new JButton("返回");
        btnNewButton.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		PlayerHomePage playerHomePage=new PlayerHomePage(username);
        		playerHomePage.setVisible(true);
				dispose();
        	}
        });
        btnNewButton.setBounds(621, 322, 84, 22);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("匯出Excel");
        btnNewButton_1.setFont(new Font("源泉圓體 M", Font.PLAIN, 12));
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 CreateExcel.exportToNewExcel(currentRecords);
        	}
        });
        btnNewButton_1.setBounds(459, 322, 125, 22);
        contentPane.add(btnNewButton_1);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBounds(5, 443, 676, 33);

       
    }
}
