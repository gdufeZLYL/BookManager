package zn.gdufe.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import zn.gdufe.dao.DaoFactory;
import zn.gdufe.dao.StudentInfoDao;
import zn.gdufe.model.StudentInfo;
import zn.gdufe.util.DbUtil;
import javax.swing.JFrame;
import java.awt.Color;

public class MyLibraryInterFrm extends JInternalFrame {
	private JTextField nicknameTxt;
	private JTextField usernameTxt;
	private JTextField majorTxt;
	private JTextField bookNumTxt;
	private static String username;
	
	private DbUtil dbUtil = new DbUtil();
	private StudentInfoDao studentInfoDao = DaoFactory.getInstance().getStudentInfoDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLibraryInterFrm frame = new MyLibraryInterFrm(username);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MyLibraryInterFrm() {
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setTitle("我的个人信息");
		setIconifiable(true);
		setBounds(100, 100, 486, 363);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MyLibraryInterFrm.class.getResource("/images/man.png")));
		
		JLabel label = new JLabel("姓名:");
		
		nicknameTxt = new JTextField();
		nicknameTxt.setEditable(false);
		nicknameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("学号:");
		
		usernameTxt = new JTextField();
		usernameTxt.setEditable(false);
		usernameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("专业:");
		
		majorTxt = new JTextField();
		majorTxt.setEditable(false);
		majorTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("当前借阅:");
		
		bookNumTxt = new JTextField();
		bookNumTxt.setEditable(false);
		bookNumTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookNumTxt))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(majorTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(nicknameTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(nicknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(majorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * Create the frame.
	 */
	public MyLibraryInterFrm(String username) {
		this.username = username;
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setTitle("我的个人信息");
		setIconifiable(true);
		setBounds(100, 100, 486, 363);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MyLibraryInterFrm.class.getResource("/images/man.png")));
		
		JLabel label = new JLabel("姓名:");
		
		nicknameTxt = new JTextField();
		nicknameTxt.setEditable(false);
		nicknameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("学号:");
		
		usernameTxt = new JTextField();
		usernameTxt.setEditable(false);
		usernameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("专业:");
		
		majorTxt = new JTextField();
		majorTxt.setEditable(false);
		majorTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("当前借阅:");
		
		bookNumTxt = new JTextField();
		bookNumTxt.setEditable(false);
		bookNumTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookNumTxt))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(61)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(majorTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(nicknameTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(nicknameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(majorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		fillInfo(username);
		
	}
	
	private void fillInfo(String username) {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			StudentInfo studentInfo = studentInfoDao.getStudentInfo(con, username);
			this.nicknameTxt.setText(studentInfo.getNickname());
			this.usernameTxt.setText(studentInfo.getUsername());
			this.majorTxt.setText(studentInfo.getMajor());
			this.bookNumTxt.setText(studentInfo.getBookNum()+"本");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
