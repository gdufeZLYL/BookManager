package zn.gdufe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import zn.gdufe.dao.BookTypeDao;
import zn.gdufe.model.BookType;
import zn.gdufe.util.StringUtil;

public class BookTypeDaoImpl implements BookTypeDao {
	/**
	 * 图书类别添加
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, BookType bookType) throws Exception {
		String sql = "insert into t_bookType values(null, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		//byte[] b = bookType.getBookTypeName().getBytes("UTF-8");
		System.out.println(bookType.getBookTypeName());
		ps.setString(1, bookType.getBookTypeName());
		//b = bookType.getBookTypeDesc().getBytes("UTF-8");
		ps.setString(2, bookType.getBookTypeDesc());
		return ps.executeUpdate();
	}
	
	/**
	 * 查询图书类别集合
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, BookType bookType) throws Exception {
		StringBuffer sb = new StringBuffer("select * from t_bookType");
		System.out.println(bookType.getBookTypeName());
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			//byte[] b = bookType.getBookTypeName().getBytes("UTF-8");
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");	
		}
		PreparedStatement ps = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return ps.executeQuery();
	}
	
	/**
	 * 删除图书类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception {
		String sql = "delete from t_bookType where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	
	/**
	 * 更新图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, BookType bookType) throws Exception {
		String sql = "update t_bookType set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bookType.getBookTypeName());
		ps.setString(2, bookType.getBookTypeDesc());
		ps.setInt(3, bookType.getId());
		return ps.executeUpdate();
	}
}
