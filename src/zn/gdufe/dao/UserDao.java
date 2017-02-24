package zn.gdufe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import zn.gdufe.model.User;

/**
 * 用户Dao类
 * @author zn
 *
 */
public interface UserDao {
	
	/**
	 * 管理员登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User loginAdmin(Connection con, User user) throws Exception;
	
	/**
	 * 学生登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User loginStudent(Connection con, User user) throws Exception;
}
