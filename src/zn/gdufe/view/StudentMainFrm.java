package zn.gdufe.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenu;

import zn.gdufe.model.LoginEvent;
import zn.gdufe.model.LoginEventListener;
import zn.gdufe.util.StringUtil;

public class StudentMainFrm extends JFrame {

	private JPanel contentPane;
	private static String username;
	JDesktopPane table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMainFrm frame = new StudentMainFrm(username);
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
	
	public StudentMainFrm() {
		
		setTitle("图书馆书目检索系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("图书操作");
		mnNewMenu.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/book1.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("书目检索");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuBookSearchInterFrm stuBookSearchInterFrm = new StuBookSearchInterFrm();
				stuBookSearchInterFrm.setVisible(true);
				table.add(stuBookSearchInterFrm);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/search.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("图书借阅");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuBookBorrowInterFrm stuBookBorrowInterFrm = new StuBookBorrowInterFrm(username);
				stuBookBorrowInterFrm.setVisible(true);
				table.add(stuBookBorrowInterFrm);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/borrowbook.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem = new JMenuItem("安全退出");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				//System.out.println(result);
				if(result == 0) {
					dispose();
				}
			}
		});
		menuItem.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/exit.png")));
		mnNewMenu.add(menuItem);
		
		JMenu mnNewMenu_1 = new JMenu("我的图书馆");
		mnNewMenu_1.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/forStudent.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("个人信息");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyLibraryInterFrm myLibraryInterFrm = new MyLibraryInterFrm();
				myLibraryInterFrm.setVisible(true);
				table.add(myLibraryInterFrm);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/userName.png")));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	/**
	 * Create the frame.
	 */
	public StudentMainFrm(final String username) {
		this.username = username;
		
		setTitle("图书馆书目检索系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("图书操作");
		mnNewMenu.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/book1.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("书目检索");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuBookSearchInterFrm stuBookSearchInterFrm = new StuBookSearchInterFrm();
				stuBookSearchInterFrm.setVisible(true);
				table.add(stuBookSearchInterFrm);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/search.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("图书借阅");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuBookBorrowInterFrm stuBookBorrowInterFrm = new StuBookBorrowInterFrm(username);
				stuBookBorrowInterFrm.setVisible(true);
				table.add(stuBookBorrowInterFrm);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/borrowbook.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem = new JMenuItem("安全退出");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统");
				//System.out.println(result);
				if(result == 0) {
					dispose();
				}
			}
		});
		menuItem.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/exit.png")));
		mnNewMenu.add(menuItem);
		
		JMenu mnNewMenu_1 = new JMenu("我的图书馆");
		mnNewMenu_1.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/forStudent.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("个人信息");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyLibraryInterFrm myLibraryInterFrm = new MyLibraryInterFrm(username);
				myLibraryInterFrm.setVisible(true);
				table.add(myLibraryInterFrm);
			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon(StudentMainFrm.class.getResource("/images/userName.png")));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
