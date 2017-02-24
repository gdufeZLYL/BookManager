package zn.gdufe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import zn.gdufe.dao.UserDao;
import zn.gdufe.model.User;

public class UserDaoImpl implements UserDao{
	/**
	 * 管理员登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User loginAdmin(Connection con, User user) throws Exception {
		User resultUser = null;
		String sql = "select * from t_admin where username=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUsername(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
			
		}
		return resultUser;
	}
	
	/**
	 * 学生登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User loginStudent(Connection con, User user) throws Exception {
		User resultUser = null;
		String sql = "select * from t_student where username=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUsername(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
			
		}
		return resultUser;
	}
}
