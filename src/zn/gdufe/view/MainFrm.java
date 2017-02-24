package zn.gdufe.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("图书管理系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 371);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Menu1 = new JMenu("基本数据维护");
		Menu1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menuBar.add(Menu1);
		
		JMenu Menu11 = new JMenu("图书类别管理");
		Menu11.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		Menu1.add(Menu11);
		
		JMenuItem MenuItem2 = new JMenuItem("图书类别添加");
		MenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeAddInterFrm = new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
			}
		});
		MenuItem2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		Menu11.add(MenuItem2);
		
		JMenuItem MenuItem3 = new JMenuItem("图书类别维护");
		MenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManageInterFrm bookTypeManageInterFrm = new BookTypeManageInterFrm();
				bookTypeManageInterFrm.setVisible(true);
				table.add(bookTypeManageInterFrm);
			}
		});
		MenuItem3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		Menu11.add(MenuItem3);
		
		JMenu Menu12 = new JMenu("图书管理");
		Menu12.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		Menu1.add(Menu12);
		
		JMenuItem MenuItem4 = new JMenuItem("图书添加");
		MenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm = new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
		MenuItem4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		Menu12.add(MenuItem4);
		
		JMenuItem MenuItem5 = new JMenuItem("图书维护");
		MenuItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInterFrm bookManageInterFrm = new BookManageInterFrm();
				bookManageInterFrm.setVisible(true);
				table.add(bookManageInterFrm);
			}
		});
		MenuItem5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		Menu12.add(MenuItem5);
		
		JMenuItem menuItem1 = new JMenuItem("安全退出");
		menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				//System.out.println(result);
				if(result == 0) {
					dispose();
				}
			}
		});
		menuItem1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		Menu1.add(menuItem1);
		
		JMenu Menu2 = new JMenu("关于我们");
		Menu2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuBar.add(Menu2);
		
		JMenuItem MenuItem6 = new JMenuItem("关于图书馆");
		MenuItem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryInterFrm libraryInterFrm = new LibraryInterFrm();
				libraryInterFrm.setVisible(true);
				table.add(libraryInterFrm);
			}
		});
		MenuItem6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/library.png")));
		Menu2.add(MenuItem6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

}
