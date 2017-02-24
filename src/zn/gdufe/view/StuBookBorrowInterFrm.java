package zn.gdufe.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import zn.gdufe.dao.BookDao;
import zn.gdufe.dao.BookTypeDao;
import zn.gdufe.dao.DaoFactory;
import zn.gdufe.dao.StudentInfoDao;
import zn.gdufe.model.Book;
import zn.gdufe.model.BookType;
import zn.gdufe.model.CanBorrowState;
import zn.gdufe.model.CanNotBorrowState;
import zn.gdufe.model.StudentInfo;
import zn.gdufe.util.DbUtil;
import zn.gdufe.util.StringUtil;

public class StuBookBorrowInterFrm extends JInternalFrame {
	private JTextField borrowStateTxt;
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextArea bookDescTxt;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private JComboBox bookTypeJcb;
	private static String username;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = DaoFactory.getInstance().getBookTypeDao();
	private BookDao bookDao = DaoFactory.getInstance().getBookDao();
	private StudentInfoDao studentInfoDao = DaoFactory.getInstance().getStudentInfoDao();
	private StudentInfo studentInfo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuBookBorrowInterFrm frame = new StuBookBorrowInterFrm(username);
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
	public StuBookBorrowInterFrm(String username) {
		this.username = username;
		
		setIconifiable(true);
		setClosable(true);
		setTitle("图书借阅");
		setBounds(100, 100, 516, 424);
		
		JLabel label = new JLabel("当前借阅状态:");
		
		borrowStateTxt = new JTextField();
		borrowStateTxt.setEditable(false);
		borrowStateTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("图书名称:");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("图书作者:");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("作者性别:");
		
		manJrb = new JRadioButton("男");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("女");
		buttonGroup.add(femaleJrb);
		
		JLabel label_4 = new JLabel("图书价格:");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("图书类别:");
		
		bookTypeJcb = new JComboBox();
		
		JLabel label_6 = new JLabel("图书描述:");
		
		bookDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("借书");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookBorrowActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(StuBookBorrowInterFrm.class.getResource("/images/book1.png")));
		
		JButton btnNewButton_1 = new JButton("还书");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookBackActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(StuBookBorrowInterFrm.class.getResource("/images/bookManager.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(borrowStateTxt, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bookTypeJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(manJrb)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(femaleJrb)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(priceTxt))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookDescTxt)))
					.addContainerGap(72, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addContainerGap(257, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(borrowStateTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(manJrb)
						.addComponent(femaleJrb)
						.addComponent(label_4)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_6)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		//设置文本域边框
		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		Connection con;
		studentInfo = null;
		try {
			con = dbUtil.getCon();
			studentInfo = studentInfoDao.getStudentInfo(con, username);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(studentInfo.getBookNum() >= 2)studentInfo.setState(new CanNotBorrowState(studentInfo));
		else studentInfo.setState(new CanBorrowState(studentInfo));
		borrowStateTxt.setText(studentInfo.getState().toString());
		fillBookType();
	}
	
	/**
	 * 借书事件处理
	 * @param evt
	 */
	private void bookBorrowActionPerformed(ActionEvent evt) {
		if(studentInfo.getBookNum() >= 2){
			JOptionPane.showMessageDialog(null, "你借阅的书籍数量已达到上限");
			return ;
		}
		if(StringUtil.isEmpty(this.bookNameTxt.getText())) {
			JOptionPane.showMessageDialog(null, "请填写要借的书籍信息");
			return;
		}
		Connection con = null;
		Book book = null;
		try {
			con = dbUtil.getCon();
			book = bookDao.findByBookName(con, this.bookNameTxt.getText());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String id = book.getId()+"";
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请填写要借的书籍信息");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要借用该书吗?");
		if(n==0) {
			try {
				int deleteNum = bookDao.delete(con, id);
				if(deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "借书成功!");
					studentInfo.setBookNum(studentInfo.getBookNum()+1);
					studentInfo.getState().checkState(studentInfo.getBookNum());
					studentInfoDao.update(con, studentInfo);
					this.resetValue();
					borrowStateTxt.setText(studentInfo.getState().toString());
					studentInfo = studentInfoDao.getStudentInfo(con, username);
				} else {
					JOptionPane.showMessageDialog(null, "借书失败!");
				}
			} catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "借书失败!");
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

	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.manJrb.setSelected(true);
		this.bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0) {
			this.bookTypeJcb.setSelectedIndex(0);
		}
	}
	
	/**
	 * 还书事件处理
	 * @param evt
	 */
	private void bookBackActionPerformed(ActionEvent evt) {
		String bookName = this.bookNameTxt.getText();
		String author = this.authorTxt.getText();
		String price = this.priceTxt.getText();
		String bookDesc = this.bookDescTxt.getText();
		
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空!");
			return;
		}
		
		if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空!");
			return;
		}
		
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "图书价格不能为空!");
			return;
		}
		
		String sex = "";
		if(manJrb.isSelected()) {
			sex = "男";
		} else if(femaleJrb.isSelected()) {
			sex = "女";
		}
		
		BookType bookType = (BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId = bookType.getId();
		
		Book book = new Book(bookName,author,sex,Float.parseFloat(price),bookTypeId,bookDesc);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = bookDao.add(con, book);
			if(addNum == 1){
				JOptionPane.showMessageDialog(null, "还书成功!");
				studentInfo.setBookNum(studentInfo.getBookNum()-1);
				studentInfo.getState().checkState(studentInfo.getBookNum());
				studentInfoDao.update(con, studentInfo);
				resetValue();
				borrowStateTxt.setText(studentInfo.getState().toString());
				studentInfo = studentInfoDao.getStudentInfo(con, username);
			} else {
				JOptionPane.showMessageDialog(null, "还书失败!");
			}
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "还书失败!");
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
	 * 初始化图书类别下拉框
	 */
	private void fillBookType() {
		Connection con = null;
		BookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, new BookType());
			while(rs.next()) {
				bookType = new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
}
