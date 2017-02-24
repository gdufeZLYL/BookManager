package zn.gdufe.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * @author zn
 *
 */
public class DbUtil {
	
	//数据库连接
	private String dbUrl="jdbc:mysql://localhost:3306/db_book?useUnicode=true&characterEncoding=GBK";
	//用户名
	private String dbUsername="root";
	//密码
	private String dbPassword="123456";
	//驱动名称
	private String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception {
		if(con != null) {
			con.close();
		}
	}
	
	public static void main(String args[]) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败!");
		}
	}
}
