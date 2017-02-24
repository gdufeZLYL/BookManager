package zn.gdufe.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.JPasswordField;

import zn.gdufe.dao.DaoFactory;
import zn.gdufe.dao.UserDao;
import zn.gdufe.model.LoginEvent;
import zn.gdufe.model.LoginEventListener;
import zn.gdufe.model.LoginValidator;
import zn.gdufe.model.User;
import zn.gdufe.util.DbUtil;
import zn.gdufe.util.StringUtil;

public class logOnFrm extends JFrame{

	private JPanel contentPane;
	private JTextField usernameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordTxt;
	private JRadioButton forStudent;
	private JRadioButton forAdmin;
	
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = DaoFactory.getInstance().getUserDao();
	
	LoginEventListener lel;
	LoginEvent le;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logOnFrm frame = new logOnFrm();
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
	public logOnFrm() {
		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		setResizable(false);
		setTitle("用户登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel libraryLb = new JLabel("图书馆系统");
		libraryLb.setFont(new Font("宋体", Font.BOLD, 23));
		libraryLb.setIcon(new ImageIcon(logOnFrm.class.getResource("/images/logo.png")));
		
		JLabel usernameLb = new JLabel("用户名:");
		usernameLb.setIcon(new ImageIcon(logOnFrm.class.getResource("/images/userName.png")));
		
		JLabel passwordLb = new JLabel("密   码:");
		passwordLb.setIcon(new ImageIcon(logOnFrm.class.getResource("/images/password.png")));
		
		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		
		forStudent = new JRadioButton("学生");
		buttonGroup.add(forStudent);
		forStudent.setSelected(true);
		
		forAdmin = new JRadioButton("管理员");
		buttonGroup.add(forAdmin);
		
		JButton submit = new JButton("登录");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		submit.setIcon(new ImageIcon(logOnFrm.class.getResource("/images/login.png")));
		
		JButton reset = new JButton("重置");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		reset.setIcon(new ImageIcon(logOnFrm.class.getResource("/images/reset.png")));
		
		passwordTxt = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(119)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(libraryLb, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(usernameLb)
								.addGap(18)
								.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(passwordLb)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(passwordTxt))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(9)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(forStudent)
									.addComponent(submit))
								.addGap(51)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(forAdmin)
									.addComponent(reset)))))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(libraryLb)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameLb)
						.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordLb)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(forAdmin)
						.addComponent(forStudent))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(reset)
						.addComponent(submit))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置JFrame居中显示
		this.setLocationRelativeTo(null);
		addLoginEventListener(new LoginValidator());
	}
	
	/**
	 * 实现具体观察者方法
	 * @param lel
	 */
	public void addLoginEventListener(LoginEventListener lel) {
		this.lel = lel;
	}
	
	/**
	 * 实现通知方法
	 * @param iden
	 * @return
	 */
	private int fireLoginEvent(String iden) {
		le = new LoginEvent(iden);
		return lel.validateLogin(le);
	}
	
	/**
	 * 登录事件处理
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent evt) {
		String username = this.usernameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		String identity;
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空!");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空!");
			return;
		}
		if(forStudent.isSelected()) {
			identity = "student";
		} else {
			identity = "admin";
		}
		
		User user = new User(username, password);
		Connection con = null;
		try {
			User currentUser = null;
			con = dbUtil.getCon();
			if(fireLoginEvent(identity) == 1) {
				currentUser = userDao.loginAdmin(con, user);
				if(currentUser != null) {
					//JOptionPane.showMessageDialog(null, "登录成功!");
					dispose();
					new MainFrm().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "用户名或者密码错误!");
				}
			} else {
				currentUser = userDao.loginStudent(con, user);
				if(currentUser != null) {
					//JOptionPane.showMessageDialog(null, "登录成功!");
					dispose();
					new StudentMainFrm(currentUser.getUsername()).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "用户名或者密码错误!");
				}
			}
			
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

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.usernameTxt.setText("");
		this.passwordTxt.setText("");
	}
}
