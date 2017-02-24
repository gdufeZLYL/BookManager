package zn.gdufe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import zn.gdufe.dao.BookDao;
import zn.gdufe.model.Book;
import zn.gdufe.util.StringUtil;

/**
 * BookDao具体实现类
 * @author zn
 *
 */
public class BookDaoImpl implements BookDao {
	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Book book) throws Exception {
		String sql = "insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, book.getBookName());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getSex());
		ps.setFloat(4, book.getPrice());
		ps.setInt(5, book.getBookTypeId());
		ps.setString(6, book.getBookDesc());
		return ps.executeUpdate();
	}
	
	/**
	 * 图书信息查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Book book) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_book b,t_bookType bt where b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())) {
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())) {
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId()!=null && book.getBookTypeId()!=-1) {
			sb.append(" and b.bookTypeId="+book.getBookTypeId());
		}
		PreparedStatement ps = con.prepareStatement(sb.toString());
		return ps.executeQuery();
	}
	
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception {
		String sql = "delete from t_book where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	
	/**
	 * 图书信息修改
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Book book) throws Exception {
		String sql = "update t_book set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, book.getBookName());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getSex());
		ps.setFloat(4, book.getPrice());
		ps.setString(5, book.getBookDesc());
		ps.setInt(6, book.getBookTypeId());
		ps.setInt(7, book.getId());
		return ps.executeUpdate();
	}
	
	/**
	 * 指定图书类别下是否存在图书
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	public boolean existBookByBookTypeId(Connection con,String bookTypeId) throws Exception {
		String sql = "select * from t_book where bookTypeId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bookTypeId);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	
	/**
	 * 查找指定书名的书籍
	 * @param con
	 * @param bookName
	 * @return
	 * @throws Exception
	 */
	public Book findByBookName(Connection con, String bookName) throws Exception {
		String sql = "select * from t_book where bookName=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bookName);
		ResultSet rs = ps.executeQuery();
		Book book = null;
		if(rs.next()) {
			book = new Book();
			book.setId(rs.getInt("id"));
			book.setBookName(rs.getString("bookName"));
			book.setAuthor(rs.getString("author"));
			book.setSex(rs.getString("sex"));
			book.setPrice(rs.getFloat("price"));
			book.setBookTypeId(rs.getInt("bookTypeId"));
			book.setBookDesc(rs.getString("bookDesc"));
		}
		return book;
	}
}
