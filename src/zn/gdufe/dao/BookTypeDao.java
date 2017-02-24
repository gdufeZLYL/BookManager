package zn.gdufe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import zn.gdufe.model.BookType;
import zn.gdufe.util.StringUtil;

/**
 * 图书类别Dao类
 * @author zn
 *
 */
public interface BookTypeDao {
	
	/**
	 * 图书类别添加
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, BookType bookType) throws Exception;
	
	/**
	 * 查询图书类别集合
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, BookType bookType) throws Exception;
	
	/**
	 * 删除图书类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception;
	
	/**
	 * 更新图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, BookType bookType) throws Exception;
}
