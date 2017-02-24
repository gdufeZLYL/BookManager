package zn.gdufe.model;

import java.sql.Connection;

import zn.gdufe.dao.BookDao;
import zn.gdufe.dao.DaoFactory;

/**
 * 学生借阅状态类
 * 应用:状态模式
 * @author zn
 *
 */
public abstract class AbstractState {
	protected StudentInfo studentInfo;
	protected String stateName;
	public abstract void checkState(int newBookNum);
	
	/**
	 * 借书
	 * @param con
	 * @param book
	 */
	public void borrow(Connection con, String id) {
		BookDao bookDao = DaoFactory.getInstance().getBookDao();
		try {
			bookDao.delete(con, id);
			//当前借阅书籍数量+1
			int newBookNum = studentInfo.getBookNum()+1;
			studentInfo.setBookNum(newBookNum);
			checkState(studentInfo.getBookNum());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void back(Connection con, Book book) {
		BookDao bookDao = DaoFactory.getInstance().getBookDao();
		try {
			bookDao.add(con, book);
			//当前借阅书籍数量-1
			int newBookNum = studentInfo.getBookNum()-1;
			studentInfo.setBookNum(newBookNum);
			checkState(studentInfo.getBookNum());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
