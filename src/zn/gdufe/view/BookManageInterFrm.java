package zn.gdufe.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import zn.gdufe.dao.BookDao;
import zn.gdufe.dao.BookTypeDao;
import zn.gdufe.dao.DaoFactory;
import zn.gdufe.model.Book;
import zn.gdufe.model.BookType;
import zn.gdufe.util.DbUtil;
import zn.gdufe.util.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookManageInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	private JComboBox s_bookTypeJcb;
	
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = DaoFactory.getInstance().getBookTypeDao();
	private BookDao bookDao = DaoFactory.getInstance().getBookDao();
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JTextField authorTxt;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private JTextArea bookDescTxt;
	private JComboBox bookTypeJcb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	public BookManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("图书管理");
		setBounds(100, 100, 790, 588);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE))
							.addGap(40))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		JLabel label_3 = new JLabel("编号:");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("图书名称:");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("作者性别:");
		
		manJrb = new JRadioButton("男");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		femaleJrb = new JRadioButton("女");
		buttonGroup.add(femaleJrb);
		
		JLabel label_6 = new JLabel("价格:");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_7 = new JLabel("图书作者:");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_8 = new JLabel("图书类别:");
		
		bookTypeJcb = new JComboBox();
		
		JLabel label_9 = new JLabel("图书描述:");
		
		bookDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookUpdateActionPerformed(evt);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bookDeleteActionPerformed(evt);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(label_4)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_6)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(label_7)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(authorTxt)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_5)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(manJrb)
										.addGap(18)
										.addComponent(femaleJrb))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(label_8)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))))
							.addComponent(label_9)
							.addComponent(bookDescTxt, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1)))
					.addContainerGap(166, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(manJrb)
						.addComponent(femaleJrb))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_9)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("图书名称:");
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("图书作者:");
		
		s_authorTxt = new JTextField();
		s_authorTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("图书类别:");
		
		s_bookTypeJcb = new JComboBox();
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/search.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(button)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent met) {
				bookTableMousePressed(met);
			}
		});
		scrollPane.setViewportView(bookTable);
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(132);
		getContentPane().setLayout(groupLayout);
		
		//设置文本域边框
		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
		this.fillBookType("search");
		this.fillBookType("modify");
		this.fillTable(new Book());

	}
	
	/**
	 * 图书删除事件处理
	 * @param evt
	 */
	private void bookDeleteActionPerformed(ActionEvent evt) {
		String id = idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除该记录吗?");
		if(n==0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int deleteNum = bookDao.delete(con, id);
				if(deleteNum == 1) {
					JOptionPane.showMessageDialog(null, "删除成功!");
					this.resetValue();
					this.fillTable(new Book());
				} else {
					JOptionPane.showMessageDialog(null, "删除失败!");
				}
			} catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败!");
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
	 * 图书修改事件处理
	 * @param evt
	 */
	private void bookUpdateActionPerformed(ActionEvent evt) {
		String id = this.idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录!");
			return;
		}
		
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
		
		Book book = new Book(Integer.parseInt(id),bookName,author,sex,Float.parseFloat(price),bookTypeId,bookDesc);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = bookDao.update(con, book);
			if(addNum == 1){
				JOptionPane.showMessageDialog(null, "图书修改成功!");
				resetValue();
				this.fillTable(new Book());
			} else {
				JOptionPane.showMessageDialog(null, "图书修改失败!");
			}
		} catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书修改失败!");
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
	 * 重置表单
	 */
	private void resetValue() {
		this.idTxt.setText("");
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
	 * 表格行点击事件处理
	 * @param me
	 */
	private void bookTableMousePressed(MouseEvent me) {
		int row = this.bookTable.getSelectedRow();
		this.idTxt.setText((String)bookTable.getValueAt(row, 0));
		this.bookNameTxt.setText((String)bookTable.getValueAt(row, 1));
		this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
		String sex = (String)bookTable.getValueAt(row, 3);
		if("男".equals(sex)) {
			this.manJrb.setSelected(true);
		} else if("女".equals(sex)) {
			this.femaleJrb.setSelected(true);
		}
		this.priceTxt.setText((Float)bookTable.getValueAt(row, 4)+"");
		this.bookDescTxt.setText((String)bookTable.getValueAt(row, 5));
		String bookTypeName = (String)this.bookTable.getValueAt(row, 6);
		int n = this.bookTypeJcb.getItemCount();
		for(int i = 0; i < n; i++) {
			BookType item = (BookType)this.bookTypeJcb.getItemAt(i);
			if(item.getBookTypeName().equals(bookTypeName)) {
				this.bookTypeJcb.setSelectedIndex(i);
			}
		}
	}

	/**
	 * 图书查询事件处理
	 * @param e
	 */
	private void bookSearchActionPerformed(ActionEvent evt) {
		String bookName = this.s_bookNameTxt.getText();
		String author = this.s_authorTxt.getText();
		BookType bookType = (BookType) this.s_bookTypeJcb.getSelectedItem();
		int bookTypeId = bookType.getId();
		
		Book book = new Book(bookName,author,bookTypeId);
		this.fillTable(book);
	}

	/**
	 * 初始化下拉框
	 * @param type 下拉框类型
	 */
	private void fillBookType(String type) {
		Connection con = null;
		BookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.list(con, new BookType());
			if("search".equals(type)) {
				bookType = new BookType();
				bookType.setBookTypeName("请选择...");
				bookType.setId(-1);
				this.s_bookTypeJcb.addItem(bookType);
			}
			while(rs.next()) {
				bookType = new BookType();
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				bookType.setId(rs.getInt("id"));
				if("search".equals(type)) {
					this.s_bookTypeJcb.addItem(bookType);
				} else if("modify".equals(type)) {
					this.bookTypeJcb.addItem(bookType);
				}
			}
		} catch(Exception e) {
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
	 * 初始化表格数据
	 * @param book
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0); //设置成0行
		Connection con = null;
		try {
			con=dbUtil.getCon();
			ResultSet rs = bookDao.list(con, book);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v);
			}
		} catch(Exception e) {
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
