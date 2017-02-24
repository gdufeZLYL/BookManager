package zn.gdufe.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import zn.gdufe.dao.BookTypeDao;
import zn.gdufe.dao.DaoFactory;
import zn.gdufe.model.BookType;
import zn.gdufe.util.DbUtil;
import zn.gdufe.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;

public class BookTypeAddInterFrm extends JInternalFrame {
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = DaoFactory.getInstance().getBookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
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
	public BookTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("图书类别添加");
		setBounds(100, 100, 519, 354);
		
		JLabel lblNewLabel = new JLabel("图书类别名称:");
		
		JLabel lblNewLabel_1 = new JLabel("图书类别描述:");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		bookTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/add.png")));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(bookTypeDescTxt, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(btnNewButton)
							.addGap(81)
							.addComponent(btnNewButton_1)))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		//设置文本域边框
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}
	
	/**
	 * 图书类别添加事件处理
	 * @param e
	 */
	private void bookTypeAddActionPerformed(ActionEvent evt) {
		String bookTypeName = this.bookTypeNameTxt.getText();
		String bookTypeDesc = this.bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空!");
			return;
		}
		BookType bookType = new BookType(bookTypeName, bookTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int n = bookTypeDao.add(con, bookType);
			if(n == 1) {
				JOptionPane.showMessageDialog(null, "图书类别添加成功!");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "图书类别添加失败!");
			}
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类别添加失败!");
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
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
		
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
