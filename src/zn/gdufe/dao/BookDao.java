package zn.gdufe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import zn.gdufe.model.Book;
import zn.gdufe.util.StringUtil;

/**
 * 图书Dao类
 * @author zn
 *
 */
public interface BookDao {
	
	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Book book) throws Exception ;
	
	/**
	 * 图书信息查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Book book) throws Exception ;
	
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception ;
	
	/**
	 * 图书信息修改
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Book book) throws Exception ;
	
	/**
	 * 指定图书类别下是否存在图书
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	public boolean existBookByBookTypeId(Connection con,String bookTypeId) throws Exception ;
	
	/**
	 * 查找指定书名的书籍
	 * @param con
	 * @param bookName
	 * @return
	 * @throws Exception
	 */
	public Book findByBookName(Connection con, String bookName) throws Exception;
}
